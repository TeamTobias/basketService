package com.tobias.cartService.inner.repository;

import com.tobias.cartService.inner.domain.WishList;
import org.springframework.data.repository.CrudRepository;

public interface WishListRepository extends CrudRepository<WishList, Long> {
}
