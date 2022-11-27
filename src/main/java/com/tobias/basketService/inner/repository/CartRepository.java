package com.tobias.basketService.inner.repository;

import com.tobias.basketService.inner.domain.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
    Cart findById(int id);
    Cart findByUserId(int userId);
}
