package com.tobias.basketService.inner.domain;

import lombok.Data;

@Data
public class ResponseWishList {
    private int id;
    private int userId;
    private int count;
    private Iterable<WishItem> wishItems;
}
