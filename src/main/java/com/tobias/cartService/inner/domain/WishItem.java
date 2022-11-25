package com.tobias.cartService.inner.domain;

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

}
