package com.tobias.basketService.inner.repository;

import com.tobias.basketService.inner.domain.WishList;
import org.springframework.data.repository.CrudRepository;

public interface WishListRepository extends CrudRepository<WishList, Long> {
    WishList findByUserId(int userId);
    WishList findById(int id);
}
