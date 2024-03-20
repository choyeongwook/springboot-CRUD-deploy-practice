package com.practice.spring.service;

import com.practice.spring.domain.Member;
import com.practice.spring.dto.MemberRequestDto;
import com.practice.spring.dto.MemberRequestDto.*;
import com.practice.spring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }
    public Optional<Member> getMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public Member join(MemberJoinRequestDto memberJoinRequestDto) {
        Member member = new Member();
        member.setName(memberJoinRequestDto.getName());
        return memberRepository.save(member);
    }

    public Member updateMember(MemberUpdateRequestDto memberUpdateRequestDto) {
        Member member = memberRepository.findById(memberUpdateRequestDto.getId()).orElseThrow();

        member.setName(memberUpdateRequestDto.getName());

        return memberRepository.save(member);
    }

    public Long deleteMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow();
        Long deletedId = memberRepository.deleteMember(member);
        return deletedId;
    }
}
