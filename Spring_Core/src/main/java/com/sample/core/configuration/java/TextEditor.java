/**
 * 
 */
package com.sample.core.configuration.java;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author edinjos
 *
 */
public class TextEditor {
	
	private SpellChecker spellChecker;
	
	@Autowired
	public TextEditor(SpellChecker spellChecker) {
		System.out.println(this.getClass() + " instantiated...." + spellChecker);
		this.spellChecker = spellChecker;
	}

	public SpellChecker getSpellChecker() {
		System.out.println(this.getClass() + " getSpellChecker....");
		return spellChecker;
	}

	
	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println(this.getClass() + " setSpellChecker....");
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		System.out.println(this.getClass() + " spellCheck....");
		spellChecker.checkSpelling();
	}
}
