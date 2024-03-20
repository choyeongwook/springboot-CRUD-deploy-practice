package com.practice.spring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class MemberRequestDto {
    @Getter
    public static class MemberJoinRequestDto {
        private String name;
    }

    @Getter
    public static class MemberUpdateRequestDto {
        private Long id;
        private String name;
    }
}
