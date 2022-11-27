package com.tobias.basketService.inner.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
public class WishItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int wishListId;
    private int itemId;
    private String name;
    private int price;
    private UUID imgUUID;

    public static WishItem createWishItem(int wishListId, RequestWishItem item) {
        WishItem wishItem = new WishItem();
        wishItem.setWishListId(wishListId);
        wishItem.setItemId(item.getId());
        wishItem.setName(item.getName());
        wishItem.setPrice(item.getPrice());
        wishItem.setImgUUID(item.getImgUUID());
        return wishItem;
    }
}
