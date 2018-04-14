/**
 * 
 */
package com.sample.core.autowiring.name;

/**
 * @author edinjos
 *
 */
public class TextEditor {

	private SpellChecker spellChecker;
	private String name;

	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println(this.getClass() + " setSpellChecker..");
		this.spellChecker = spellChecker;
	}

	public SpellChecker getSpellChecker() {
		System.out.println(this.getClass() + " getSpellChecker..");
		return spellChecker;
	}

	public void setName(String name) {
		System.out.println(this.getClass() + " setName..");
		this.name = name;
	}

	public String getName() {
		System.out.println(this.getClass() + " getName..");
		return name;
	}

	public void spellCheck() {
		System.out.println(this.getClass() + " spellCheck..");
		spellChecker.checkSpelling();
	}
}
