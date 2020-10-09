package com.spring.basic.spring_demo.discount;

import com.spring.basic.spring_demo.member.Grade;
import com.spring.basic.spring_demo.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private final int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? discountFixAmount : 0;
    }
}
