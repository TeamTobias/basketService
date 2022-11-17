package com.tobias.cartService.inner.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Setter
@Entity
public class Item {
    @Id
    private int id;
    private int price;
}
