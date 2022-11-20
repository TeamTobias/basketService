package com.tobias.cartService.inner.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.coyote.Request;

import javax.persistence.*;

//@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int cartId;

    private int itemId;

    private String itemName;

    private int count;

    public static CartItem createCartItem(int cartId, RequestItem item, int amount) {
        CartItem cartItem = new CartItem();
        cartItem.setCartId(cartId);
        cartItem.setItemId(item.getItemId());
        cartItem.setItemName(item.getItemName());
        cartItem.setCount(amount);
        return cartItem;
    }

    public void addCount(int count) {
        this.count += count;
    }

}
