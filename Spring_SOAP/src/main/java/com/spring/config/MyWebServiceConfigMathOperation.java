/**
 * 
 */
package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * @author edinjos
 *
 */
@EnableWs
@Configuration
public class MyWebServiceConfigMathOperation extends WsConfigurerAdapter {

	public MyWebServiceConfigMathOperation() {
		System.out.println(this.getClass() + " instantiated...");
	}

	@Bean(name = "operation")
	// It’s important to notice that you need to specify bean names for
	// MessageDispatcherServlet and DefaultWsdl11Definition. Bean names
	// determine the URL under which web service and the generated WSDL file is
	// available. In this case, the WSDL will be available under
	public DefaultWsdl11Definition defaultWsdl11Definition(
			XsdSchema operationSchema) {
		System.out.println(this.getClass() + " defaultWsdl11Definition...");
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("OperationPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://test.math.bottom.com/");
		wsdl11Definition.setSchema(operationSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema operationSchema() {
		System.out.println(this.getClass() + " operationSchema...");
		return new SimpleXsdSchema(new ClassPathResource(
				"mathutility_schema1.xsd"));
	}
}
