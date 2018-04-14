/**
 * 
 */
package com.spring.interceptor;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthenticationInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("---preHandle executed---");
		Enumeration<String> headerEnum = request.getHeaderNames();

		while (headerEnum.hasMoreElements()) {
			String headerName = headerEnum.nextElement();
			System.out
					.println(headerName + " " + request.getHeader(headerName));
			if (headerName.equalsIgnoreCase("authorization")) {
				decode(request.getHeader(headerName));
			}
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("---postHandle executed---");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("---Request Completed---");

	}

	private static String[] decode(final String authorization) {
		System.out.println("decode... : " + authorization);

		// Authorization: Basic base64credentials
		String base64Credentials = authorization.substring("Basic".length())
				.trim();
		String credentials = new String(Base64.getDecoder().decode(
				base64Credentials), Charset.forName("UTF-8"));
		// credentials = username:password
		final String[] values = credentials.split(":", 2);
		System.out.println("values... : " + values[0]+" " + values[1]);

		return values;
	}
}