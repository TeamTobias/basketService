package com.tobias.cartService.inner.repository;

import com.tobias.cartService.inner.domain.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    CartItem findByCartIdAndItemId(int cartId,int itemId);
    Iterable<CartItem> findByCartId(int cartId);
    CartItem findByItemId(int cartItemId);
    void deleteById(int itemId);
}
