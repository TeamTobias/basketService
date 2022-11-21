package com.tobias.cartService.inner.service;

import com.tobias.cartService.inner.domain.Cart;
import com.tobias.cartService.inner.domain.CartItem;
import com.tobias.cartService.inner.domain.RequestItem;

public interface CartService {
    public void addCart(int userId, RequestItem item, int amount);

    Cart getCartByUserId(int userId);

    Iterable<CartItem> getCartItemsByCart(Cart userCart);
    void deleteCartItemById(int itemId);
}

