package com.spring.basic.spring_demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan (
//        basePackages = "com.spring.basic.spring_demo.member",
//        basePackageClasses = AppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // AppConfig.java 를 걸러낸다.
) // @Component 에노테이션이 선언된 빈들을 스캔해서 자동으로 등록시켜준다.
public class AutoAppConfig {

//
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
