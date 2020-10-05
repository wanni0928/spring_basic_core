package com.spring.basic.spring_demo.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService bean = ac.getBean(StatefulService.class);
        StatefulService bean1 = ac.getBean(StatefulService.class);

        //ThreadA : A 사용자 10000원 주문
        int userA = bean.order("UserA", 10000);
        //ThreadB : B 사용자 20000원 주문
        int userB = bean1.order("UserB", 20000);

        //ThreadA : 사용자A 주문 금액 조회
//        int price = bean.getPrice();
//        System.out.println("price = " + price);
//
//        Assertions.assertThat(bean.getPrice()).isEqualTo(20000);

        System.out.println(userA);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}