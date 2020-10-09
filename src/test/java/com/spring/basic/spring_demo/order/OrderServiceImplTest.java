package com.spring.basic.spring_demo.order;

import com.spring.basic.spring_demo.discount.FixDiscountPolicy;
import com.spring.basic.spring_demo.member.Grade;
import com.spring.basic.spring_demo.member.Member;
import com.spring.basic.spring_demo.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {
    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order itemA = orderService.createOrder(1L, "itemA", 10000);
        assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }
}