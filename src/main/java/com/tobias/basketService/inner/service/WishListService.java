package com.tobias.basketService.inner.service;

import com.tobias.basketService.inner.domain.RequestWishItem;
import com.tobias.basketService.inner.domain.WishItem;
import com.tobias.basketService.inner.domain.WishList;

public interface WishListService {
    Iterable<WishList> getWishListAll();
    void addWishList(int userId, RequestWishItem item);
    WishList getWishListByUserId(int userId);
    Iterable<WishItem> getWishItemsByWishListId(int wishListId);
    void deleteWishItemById(int id);
}
