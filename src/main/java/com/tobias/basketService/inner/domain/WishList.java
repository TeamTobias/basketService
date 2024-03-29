package com.tobias.basketService.inner.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int count;
    @OneToMany
    private List<WishItem> wishItems = new ArrayList<>();

    public static WishList createWishList(int userId) {
        WishList wishList = new WishList();
        wishList.setUserId(userId);
        wishList.setCount(0);
        return wishList;
    }
}
