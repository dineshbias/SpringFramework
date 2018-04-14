/**
 * 
 */
package com.sample.core.configuration.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author edinjos
 *
 */
@Configuration
public class OtherConfig {

	/**
	 * 
	 */
	public OtherConfig() {
		System.out.println(this.getClass() + " OtherConfig....");
	}

	@Bean
	public SpellChecker getSpellCheckerBean() {
		System.out.println(this.getClass() + " getSpellCheckerBean....");
		return new com.sample.core.configuration.java.SpellChecker();
	}

	@Bean
	public TextEditor getTextEditorBean() {
		System.out.println(this.getClass() + " getTextEditorBean....");
		return new TextEditor(getSpellCheckerBean());
	}
}
