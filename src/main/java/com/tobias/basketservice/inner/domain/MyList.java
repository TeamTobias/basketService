package com.tobias.basketservice.inner.domain;

import javax.persistence.*;

@Entity
public class MyList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;



}
