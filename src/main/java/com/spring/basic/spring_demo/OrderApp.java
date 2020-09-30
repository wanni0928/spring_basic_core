package com.spring.basic.spring_demo;

import com.spring.basic.spring_demo.member.Grade;
import com.spring.basic.spring_demo.member.Member;
import com.spring.basic.spring_demo.member.MemberService;
import com.spring.basic.spring_demo.order.Order;
import com.spring.basic.spring_demo.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null, null);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
