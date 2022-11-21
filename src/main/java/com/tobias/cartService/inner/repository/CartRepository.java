package com.tobias.cartService.inner.repository;

import com.tobias.cartService.inner.domain.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
    Cart findByUserId(int userId);
}
