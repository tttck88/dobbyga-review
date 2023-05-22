package com.example.dobbygareview.common.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class JwtTokenInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		final String header = request.getHeader("Authorization");

		if(header != null) {
			final String token = TokenUtils.getTokenFromHeader(header);
			if (TokenUtils.isValidToken(token)) {
				return true;
			}
		}

		response.sendRedirect("/error/unauthorized");
		return false;
	}
}
