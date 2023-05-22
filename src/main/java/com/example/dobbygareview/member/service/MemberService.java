package com.example.dobbygareview.member.service;


import com.example.dobbygareview.common.exception.CustomException;
import com.example.dobbygareview.common.exception.ErrorResult;
import com.example.dobbygareview.member.dto.MemberRegisterRequestDto;
import com.example.dobbygareview.member.entity.Member;
import com.example.dobbygareview.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void registerMember(final MemberRegisterRequestDto memberRegisterRequestDto) {
        if(memberRepository.findByEmail(memberRegisterRequestDto.getEmail()).isPresent()) {
            throw new CustomException(ErrorResult.DUPLICATE_USER_REGISTER);
        }

        memberRepository.save(
                Member.builder()
                .email(memberRegisterRequestDto.getEmail())
                .pw(new BCryptPasswordEncoder().encode(memberRegisterRequestDto.getPw()))
                .memberRole(memberRegisterRequestDto.getMemberRole())
                .build()
        );
    }
}
