package com.spring.basic.spring_demo;

import com.spring.basic.spring_demo.discount.DiscountPolicy;
import com.spring.basic.spring_demo.discount.RateDiscountPolicy;
import com.spring.basic.spring_demo.member.MemberRepository;
import com.spring.basic.spring_demo.member.MemberService;
import com.spring.basic.spring_demo.member.MemberServiceImpl;
import com.spring.basic.spring_demo.member.MemoryMemberRepository;
import com.spring.basic.spring_demo.order.OrderService;
import com.spring.basic.spring_demo.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 Annotaion을 하지 않을 경우 CGLIB를 사용하지 않아, 싱글톤을 보장하지 않는다.
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
