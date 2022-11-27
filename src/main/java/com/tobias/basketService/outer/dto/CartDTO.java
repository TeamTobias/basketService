package com.tobias.basketService.outer.dto;

import lombok.Data;

@Data
public class CartDTO {
    private String cart_id;
    private String userid;
    private int product_id;
    private String product_name;
    private int price;
    private int money;
    private int amount;
}
