package com.tobias.cartService.inner.service;

import com.tobias.cartService.inner.domain.Cart;
import com.tobias.cartService.inner.domain.CartItem;
import com.tobias.cartService.inner.domain.Item;
import com.tobias.cartService.inner.domain.User;

public interface CartService {
    public void addCart(User user, Item newItem, int amount);

    Cart getCartByUserId(int userId);

    Iterable<CartItem> getCartItemsByCart(Cart userCart);
    CartItem getCartItemByItem(int itemId);
    void deleteCartItemByItem(int itemId);
}
