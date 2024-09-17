package com.example.orderservice.service;

import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import io.cucumber.messages.internal.com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  private final  String TOPIC = "order-topic";

  public void createOrder(Order order){

    orderRepository.save(order);

    String orderMessage = new Gson().toJson(order);
    kafkaTemplate.send(TOPIC, orderMessage);
  }

}
