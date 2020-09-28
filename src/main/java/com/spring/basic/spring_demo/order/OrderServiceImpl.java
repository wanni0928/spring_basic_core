package com.spring.basic.spring_demo.order;

import com.spring.basic.spring_demo.discount.DiscountPolicy;
import com.spring.basic.spring_demo.discount.FixDiscountPolicy;
import com.spring.basic.spring_demo.member.Member;
import com.spring.basic.spring_demo.member.MemberRepository;
import com.spring.basic.spring_demo.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
