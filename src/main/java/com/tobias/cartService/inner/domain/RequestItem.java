package com.tobias.cartService.inner.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestItem {
    private int id;
    private String name;
    private int price;
    private String size;
    private String color;
}
