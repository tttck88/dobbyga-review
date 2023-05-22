package com.example.dobbygareview.member.dto;

import com.example.dobbygareview.member.enums.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class MemberRegisterRequestDto {

    @NotNull
    private final String email;

    @NotNull
    private final String pw;

    private final MemberRole memberRole = MemberRole.ROLE_USER;
}
