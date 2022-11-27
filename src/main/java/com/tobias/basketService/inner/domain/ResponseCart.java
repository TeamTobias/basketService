package com.tobias.basketService.inner.domain;

import lombok.Data;

@Data
public class ResponseCart {
    private int cartId;
    private int userId;
    private int count;
    private int totalPrice;
    private Iterable<CartItem> cartItems;
}
