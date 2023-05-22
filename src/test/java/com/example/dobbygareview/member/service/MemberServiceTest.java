package com.example.dobbygareview.member.service;

import com.example.dobbygareview.common.exception.CustomException;
import com.example.dobbygareview.common.exception.ErrorResult;
import com.example.dobbygareview.member.dto.MemberRegisterRequestDto;
import com.example.dobbygareview.member.entity.Member;
import com.example.dobbygareview.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    private MemberService target;

    @Mock
    private MemberRepository memberRepository;

    final String email = "tttck88@gmail.com";
    final String pw = "1234";

    @Test
    void 회원가입실패_이미존재함() {
        // given
        doReturn(Optional.of(Member.builder().email(email).build())).when(memberRepository).findByEmail(email);

        // when
        CustomException result = assertThrows(CustomException.class,
                () -> target.registerMember(MemberRegisterRequestDto.builder()
                        .email(email).pw(pw).build()));

        // then
        assertThat(result.getErrorResult()).isEqualTo(ErrorResult.DUPLICATE_USER_REGISTER);
    }
}