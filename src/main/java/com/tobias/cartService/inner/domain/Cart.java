package com.tobias.cartService.inner.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;
    private int count; // 카트에 담긴 총 상품 개수
    private int totalPrice;
    @OneToMany
    private List<CartItem> cartItems = new ArrayList<>();

//    @DateTimeFormat(pattern = "yyyy-mm-dd")
//    private LocalDate createDate; // 날짜

//    @PrePersist
//    public void createDate(){
//        this.createDate = LocalDate.now();
//    }

    public static Cart createCart(int userId) {
        Cart cart = new Cart();
        cart.setCount(0);
        cart.setTotalPrice(0);
        cart.setUserId(userId);
        return cart;
    }

}