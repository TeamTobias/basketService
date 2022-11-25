package com.tobias.cartService.inner.repository;

import com.tobias.cartService.inner.domain.WishItem;
import org.springframework.data.repository.CrudRepository;

public interface WishItemRepository extends CrudRepository<WishItem, Long> {
}
