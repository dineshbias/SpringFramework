/**
 * 
 */
package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.spring.interceptor.AuthenticationInterceptor;

@Configuration
public class MyConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	AuthenticationInterceptor getAuthenticationInterceptor() {
		System.out.println(this.getClass() + " getAuthenticationInterceptor..");
		return new AuthenticationInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println(this.getClass() + " addInterceptors..");
		registry.addInterceptor(getAuthenticationInterceptor())
				.addPathPatterns("/school/jsonHeader");
		
	}
}
