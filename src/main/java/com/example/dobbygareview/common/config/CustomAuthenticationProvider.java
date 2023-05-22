package com.example.dobbygareview.common.config;


import com.example.dobbygareview.member.dto.MyMemberDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@Log4j2
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private final UserDetailsService userDetailsService;
	private final BCryptPasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		final UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		final String memberEmail = token.getName();
		final String memberPw = (String) token.getCredentials();

		final MyMemberDetails memberDetails = (MyMemberDetails) userDetailsService.loadUserByUsername(memberEmail);
		if (!passwordEncoder.matches(memberPw, memberDetails.getPassword())) {
			throw new BadCredentialsException(memberDetails.getUsername() + "Invalid password");
		}

		return new UsernamePasswordAuthenticationToken(memberDetails, memberPw, memberDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
