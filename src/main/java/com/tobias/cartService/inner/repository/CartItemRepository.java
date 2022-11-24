package com.tobias.cartService.inner.repository;

import com.tobias.cartService.inner.domain.CartItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    List<CartItem> findByCartIdAndItemId(int cartId, int itemId);
    Iterable<CartItem> findByCartId(int cartId);
    CartItem findById(int id);
    CartItem findByItemId(int cartItemId);
    void deleteById(int itemId);
}
