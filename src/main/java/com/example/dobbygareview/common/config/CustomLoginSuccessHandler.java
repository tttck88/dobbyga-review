package com.example.dobbygareview.common.config;


import com.example.dobbygareview.member.dto.MyMemberDetails;
import com.example.dobbygareview.member.entity.Member;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
										final Authentication authentication) {
		final Member member = ((MyMemberDetails) authentication.getPrincipal()).getMember();
		final String token = TokenUtils.generateJwtToken(member);
		response.addHeader("Authorization", "BEARER" + " " + token);
	}
}
