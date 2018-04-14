package com.sample.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class InitHelloWorldProcessor1 implements BeanPostProcessor, Ordered {

	@Override
	public int getOrder() {
		return 2;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(this.getClass()
				+ " postProcessBeforeInitialization... " + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(this.getClass()
				+ " postProcessAfterInitialization... " + beanName);
		return bean;
	}

}
