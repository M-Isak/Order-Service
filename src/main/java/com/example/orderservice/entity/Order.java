package com.example.orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Order {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  private String productId;
  private int quantity;
  private String userId;
}