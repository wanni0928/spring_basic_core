package com.spring.basic.spring_demo.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
