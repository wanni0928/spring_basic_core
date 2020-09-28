package com.spring.basic.spring_demo;

import com.spring.basic.spring_demo.member.Grade;
import com.spring.basic.spring_demo.member.Member;
import com.spring.basic.spring_demo.member.MemberService;
import com.spring.basic.spring_demo.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1l, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1l);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
