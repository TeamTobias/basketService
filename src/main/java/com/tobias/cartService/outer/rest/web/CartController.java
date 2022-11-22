package com.tobias.cartService.outer.rest.web;

import com.tobias.cartService.inner.domain.*;
import com.tobias.cartService.inner.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CartController {

    private final Environment env;
    private final CartService cartService;

    @GetMapping("/welcome")
    public String welcome(){
        return env.getProperty("greeting.message");
    }

    @PostMapping("/myBasket/v1/{userId}/{itemId}")
    public String addCartItem(@PathVariable("userId") int userId, @RequestBody RequestItem item, int amount) {
        cartService.addCart(userId, item, amount);
        return "cartItem Added";
    }

    // 장바구니 페이지 접속
    @GetMapping("/myBasket/v1/{userId}")
    public ResponseEntity<ResponseCart> userCartPage(@PathVariable("userId") int userId) {
        Cart cart = cartService.getCartByUserId(userId);
        // 장바구니에 들어있는 아이템 모두 가져오기
        Iterable<CartItem> cartItems = cartService.getCartItemsByCart(cart);

        // 장바구니에 들어있는 상품들의 총 가격
        int totalPrice = 0;
        for (CartItem cartitem : cartItems) {
            totalPrice += cartitem.getCount() * cartitem.getPrice();
        }
        ResponseCart responseCart = new ResponseCart();
        responseCart.setCartId(cart.getCartId());
        responseCart.setUserId(cart.getUserId());
        responseCart.setCount(cart.getCount());
        responseCart.setTotalPrice(totalPrice);
        responseCart.setCartItems(cartItems);
        return ResponseEntity.status(HttpStatus.OK).body(responseCart);
    }

    @DeleteMapping("/myBasket/v1/{cartItemId}")
    public String deleteCartItem(@PathVariable("cartItemId") int cartItemId) {
        cartService.deleteCartItemById(cartItemId);
        return "cartItem deleted";
    }
}