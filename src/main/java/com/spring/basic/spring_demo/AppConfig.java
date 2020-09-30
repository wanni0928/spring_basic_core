package com.spring.basic.spring_demo;

import com.spring.basic.spring_demo.discount.DiscountPolicy;
import com.spring.basic.spring_demo.discount.FixDiscountPolicy;
import com.spring.basic.spring_demo.member.MemberRepository;
import com.spring.basic.spring_demo.member.MemberService;
import com.spring.basic.spring_demo.member.MemberServiceImpl;
import com.spring.basic.spring_demo.member.MemoryMemberRepository;
import com.spring.basic.spring_demo.order.OrderService;
import com.spring.basic.spring_demo.order.OrderServiceImpl;

public class AppConfig {

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
