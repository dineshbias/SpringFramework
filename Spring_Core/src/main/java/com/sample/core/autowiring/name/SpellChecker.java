/**
 * 
 */
package com.sample.core.autowiring.name;

/**
 * @author edinjos
 *
 */
public class SpellChecker {

	public SpellChecker() {
		System.out.println(this.getClass() + " Inside SpellChecker constructor.");
	}

	public void checkSpelling() {
		System.out.println(this.getClass() + " Inside checkSpelling.");
	}

}
