package com.tobias.cartService.outer.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDTO {
    private String cart_id;
    private String userid;
    private int product_id;
    private String product_name;
    private int price;
    private int money;
    private int amount;

//    private List<Item> products;
}
