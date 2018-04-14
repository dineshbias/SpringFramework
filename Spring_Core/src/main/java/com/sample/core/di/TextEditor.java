/**
 * 
 */
package com.sample.core.di;

/**
 * @author edinjos
 *
 */
public class TextEditor {
	
	private int x;
	
	private SpellChecker spellChecker;

	public TextEditor(SpellChecker spellChecker, int x) {
		System.out.println(this.getClass() + "Inside TextEditor constructor.");
		this.spellChecker = spellChecker;
		this.x=x;
	}

	public void spellCheck() {
		System.out.println(this.getClass() + "Inside spellCheck...");
		spellChecker.checkSpelling();
	}

}
