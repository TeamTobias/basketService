package com.tobias.cartService.inner.repository;

import com.tobias.cartService.inner.domain.WishItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WishItemRepository extends CrudRepository<WishItem, Long> {
    WishItem findByWishListIdAndItemId(int wishListId, int itemId);
    Iterable<WishItem> findByWishListId(int wishListId);
    WishItem findById(int id);
    void deleteById(int id);
}
