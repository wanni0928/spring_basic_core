package com.spring.basic.spring_demo.member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
