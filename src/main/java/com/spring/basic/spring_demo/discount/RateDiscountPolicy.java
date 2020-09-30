package com.spring.basic.spring_demo.discount;

import com.spring.basic.spring_demo.member.Grade;
import com.spring.basic.spring_demo.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? price * discountPercent / 100 : 0;
    }
}
