package com.tobias.basketService.inner.repository;

import com.tobias.basketService.inner.domain.WishItem;
import org.springframework.data.repository.CrudRepository;

public interface WishItemRepository extends CrudRepository<WishItem, Long> {
    WishItem findByWishListIdAndItemId(int wishListId, int itemId);
    Iterable<WishItem> findByWishListId(int wishListId);
    WishItem findById(int id);
    void deleteById(int id);
}
