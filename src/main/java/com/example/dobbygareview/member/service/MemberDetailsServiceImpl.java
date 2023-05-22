package com.example.dobbygareview.member.service;


import com.example.dobbygareview.common.exception.UserNotFoundException;
import com.example.dobbygareview.member.dto.MyMemberDetails;
import com.example.dobbygareview.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MemberDetailsServiceImpl implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public MyMemberDetails loadUserByUsername(String email) {
        return memberRepository.findByEmail(email)
                .map(u -> new MyMemberDetails(u, Collections.singleton(new SimpleGrantedAuthority(u.getMemberRole().getValue()))))
                .orElseThrow(() -> new UserNotFoundException(email));
    }
}
