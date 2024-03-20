package com.practice.spring.controller;

import com.practice.spring.domain.Member;
import com.practice.spring.dto.MemberRequestDto;
import com.practice.spring.dto.MemberRequestDto.*;
import com.practice.spring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {
    private final MemberService memberService;
    @GetMapping()
    public List<Member> getAllMember() {
        System.out.println(memberService);
        return memberService.getAllMember();
    }

    @GetMapping("/{memberId}")
    public Optional<Member> getMember(@PathVariable("memberId")Long memberId) {
        return memberService.getMember(memberId);
    }

    @GetMapping("hi")
    public String getMember2() {
        System.out.println(memberService);
        return "좋아요";
    }

    @PostMapping()
    public Member join(@RequestBody MemberJoinRequestDto memberJoinRequestDto) {
        return memberService.join(memberJoinRequestDto);
    }

    @PatchMapping()
    public Member updateMember(@RequestBody MemberUpdateRequestDto memberUpdateRequestDto) {
        return memberService.updateMember(memberUpdateRequestDto);
    }

    @DeleteMapping("{id}")
    public Long deleteMember(@PathVariable("id") Long id) {
        return memberService.deleteMember(id);
    }
}
