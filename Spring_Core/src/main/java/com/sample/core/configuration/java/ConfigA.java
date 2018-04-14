package com.sample.core.configuration.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA {

	public ConfigA() {
		System.out.println(ConfigA.class + " Instantiated......*****************************");
	}

	@Bean
	public A a() {
		return new A();
	}

}
