package com.tobias.basketService.inner.service;

import com.tobias.basketService.inner.domain.Cart;
import com.tobias.basketService.inner.domain.CartItem;
import com.tobias.basketService.inner.domain.RequestCartItem;

public interface CartService {
    Iterable<Cart> getCartsAll();

    void addCart(int userId, RequestCartItem item, int amount);

    Cart getCartByUserId(int userId);
    CartItem getCartItemById(int id);
    Iterable<CartItem> getCartItemsByCart(Cart userCart);

    void modifyCartItemCount(int id, int amount);
    void deleteCartItemById(int itemId);
}

