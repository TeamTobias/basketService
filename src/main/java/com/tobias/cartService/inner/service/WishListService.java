package com.tobias.cartService.inner.service;

import com.tobias.cartService.inner.domain.RequestCartItem;
import com.tobias.cartService.inner.domain.RequestWishItem;
import com.tobias.cartService.inner.domain.WishItem;
import com.tobias.cartService.inner.domain.WishList;

public interface WishListService {
    Iterable<WishList> getWishListAll();
    void addWishList(int userId, RequestWishItem item);
    WishList getWishListByUserId(int userId);
    Iterable<WishItem> getWishItemsByWishListId(int wishListId);
    void deleteWishItemById(int id);
}
