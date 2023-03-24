package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder



public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private float price;
    private String imageURL;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cart cart;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Category category;
}
