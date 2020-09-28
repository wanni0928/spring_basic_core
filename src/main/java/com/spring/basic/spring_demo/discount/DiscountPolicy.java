package com.spring.basic.spring_demo.discount;

import com.spring.basic.spring_demo.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);

}
