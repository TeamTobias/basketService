package com.tobias.basketService.outer.rest.web;

import com.tobias.basketService.inner.domain.*;
import com.tobias.basketService.inner.service.CartService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class CartController {

    private final Environment env;
    private final CartService cartService;

    @GetMapping("/health_check")
    public String status() {
        return env.getProperty("greeting.message");
    }

    @PostMapping("/myBasket/v1/{userId}")
    public HttpStatus addCartItem(@PathVariable("userId") int userId, @RequestBody RequestCartItem item) {
        cartService.addCart(userId, item, 1);
        return HttpStatus.OK;
    }

    @GetMapping("/myBasket/v1/allcarts")
    public ResponseEntity<List<ResponseCart>> allUserCart() {
        Iterable<Cart> carts = cartService.getCartsAll();

        List<ResponseCart> result = new ArrayList<>();
        carts.forEach(v -> result.add(new ModelMapper().map(v, ResponseCart.class)));
        return ResponseEntity.status(HttpStatus.OK).body(result);
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
        responseCart.setCartId(cart.getId());
        responseCart.setUserId(cart.getUserId());
        responseCart.setCount(cart.getCount());
        responseCart.setTotalPrice(totalPrice);
        responseCart.setCartItems(cartItems);
        return ResponseEntity.status(HttpStatus.OK).body(responseCart);
    }

    @DeleteMapping("/myBasket/v1/{cartItemId}/{amount}")
    public HttpStatus deleteOneCartItem(@PathVariable("cartItemId") int cartItemId,@PathVariable("amount") int amount) {
        cartService.modifyCartItemCount(cartItemId, amount);
        return HttpStatus.OK;
    }

    @DeleteMapping("/myBasket/v1/{cartItemId}")
    public HttpStatus deleteCartItem(@PathVariable("cartItemId") int cartItemId) {
        cartService.deleteCartItemById(cartItemId);
        return HttpStatus.OK;
    }
}