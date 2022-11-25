package com.tobias.cartService.inner.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestCartItem {
    private int id;
    private String name;
    private int price;
    private String size;
    private String color;
    private UUID imgUUID;
}
