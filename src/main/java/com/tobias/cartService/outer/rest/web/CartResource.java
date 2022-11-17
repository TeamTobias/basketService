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
public class CartResource {

    private final Environment env;
    private final CartService cartService;

    @PostMapping("/user/cart/{id}/{itemId}")
    public String addCartItem(@PathVariable("id") Integer id, @PathVariable("itemId") Integer itemId, int amount) {

        User user = userPageService.findUser(id);
        Item item = itemService.itemView(itemId);

        cartService.addCart(user, item, amount);

        return "Item Added";
    }

    // 장바구니 페이지 접속
    @GetMapping("/user/cart/{id}")
    public ResponseEntity<ResponseUserCart> userCartPage(@PathVariable("id") Integer id) {
        //추후 security에서 id와 principalDetails.getId()가 같은지 확인

        User user = userPageService.findUser(id);
        // 로그인 되어 있는 유저에 해당하는 장바구니 가져오기
        Cart userCart = user.getCart();

        // 장바구니에 들어있는 아이템 모두 가져오기
        Iterable<CartItem> cartItems = cartService.getCartItemsByCart(userCart);

        // 장바구니에 들어있는 상품들의 총 가격
        int totalPrice = 0;
        for (CartItem cartitem : cartItems) {
            totalPrice += cartitem.getCount() * cartitem.getItem().getPrice();
        }

        ResponseUserCart responseUserCart = new ResponseUserCart(user, cartItems, userCart.getCount(), totalPrice);
        return ResponseEntity.status(HttpStatus.OK).body(responseUserCart);
    }

    @GetMapping("/user/cart/{id}/{cartItemId}/delete")
    public ResponseEntity<ResponseUserCart> deleteCartItem(@PathVariable("id") Integer userId, @PathVariable("cartItemId") Integer itemId) {
        //추후 security에서 id와 principalDetails.getId()가 같은지 확인

        User user = userPageService.findUser(id);

        CartItem cartItem = cartService.getCartItemByItem(itemId);

        // 장바구니 물건 삭제
        cartService.deleteCartItemByItem(itemId);

        // 해당 유저의 카트 찾기
        Cart userCart = cartService.getCartByUserId(userId);

        // 해당 유저의 장바구니 상품들
        Iterable<CartItem> cartItems = cartService.getCartItemsByCart(userCart);

        // 총 가격 += 수량 * 가격
        int totalPrice = 0;
        for (CartItem cartitem : cartItems) {
            totalPrice += cartitem.getCount() * cartitem.getItem().getPrice();
        }

        // 총 개수 += 수량
        //int totalCount = 0;
        //for (CartItem cartitem : cartItemList) {
        //    totalCount += cartitem.getCount();
        //}
        userCart.setCount(userCart.getCount() - cartItem.getCount());

        ResponseUserCart responseUserCart = new ResponseUserCart(user, cartItems, userCart.getCount(), totalPrice);
        return ResponseEntity.status(HttpStatus.OK).body(responseUserCart);
    }
}