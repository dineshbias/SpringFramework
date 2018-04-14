package com.sample.core.configuration.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ConfigA.class)
public class ConfigB {

	public ConfigB() {
		System.out.println(ConfigB.class+ " Instantiated...... *****************************");
	}

	@Bean
	public B a() {
		return new B();
	}

}
