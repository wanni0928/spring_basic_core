package com.spring.basic.spring_demo.autowired;

import com.spring.basic.spring_demo.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {
    @Test
    void autoWiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member bean1) {
            System.out.println( "bean1 : " + bean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member bean2) {
            System.out.println( "bean2 : " + bean2);
        }

        @Autowired(required = false)
        public void setNoBean3(Optional<Member> bean3) {
            System.out.println( "bean3 : " + bean3);
        }
    }
}
