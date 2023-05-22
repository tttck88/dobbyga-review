package com.example.dobbygareview.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtTokenInterceptor())
			.addPathPatterns("/api/*");
	}

	@Bean
	public JwtTokenInterceptor jwtTokenInterceptor() {
		return new JwtTokenInterceptor();
	}
}
























