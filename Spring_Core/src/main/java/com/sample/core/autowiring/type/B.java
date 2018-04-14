package com.sample.core.autowiring.type;

public class B {

	private A spellChecker;
	private String name;

	public B() {
		System.out.println("Inside B constructor.");
	}

	public A getSpellChecker() {
		System.out.println(this.getClass() + " getSpellChecker.");
		return spellChecker;
	}

	public void setSpellChecker(A spellChecker) {
		System.out.println(this.getClass() + " setSpellChecker.");
		this.spellChecker = spellChecker;
	}

	public String getName() {
		System.out.println(this.getClass() + " getName.");
		return name;
	}

	public void setName(String name) {
		System.out.println(this.getClass() + " setName.");
		this.name = name;
	}

}
