package com.spring.basic.spring_demo.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
