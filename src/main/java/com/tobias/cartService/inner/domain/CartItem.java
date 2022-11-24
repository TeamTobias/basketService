package com.tobias.cartService.inner.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

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
    private String name;
    private int price;
    private String color;
    private String size;
    private UUID thumbnailUUID;
    private int count;

    public static CartItem createCartItem(int cartId, RequestItem item, int amount) {
        CartItem cartItem = new CartItem();
        cartItem.setCartId(cartId);
        cartItem.setItemId(item.getId());
        cartItem.setName(item.getName());
        cartItem.setPrice(item.getPrice());
        cartItem.setColor(item.getColor());
        cartItem.setSize(item.getSize());
        cartItem.setThumbnailUUID(item.getThumbnailUUID());
        cartItem.setCount(amount);
        return cartItem;
    }

    public void addCount(int count) {
        this.count += count;
    }

}
