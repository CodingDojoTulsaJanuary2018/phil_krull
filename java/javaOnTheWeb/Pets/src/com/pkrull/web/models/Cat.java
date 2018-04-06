package com.pkrull.web.models;

public class Cat extends Animal implements Pet {

	public Cat() {
		// TODO Auto-generated constructor stub
	}

	public Cat(String name, String breed, double weight) {
		super(name, breed, weight);
		// TODO Auto-generated constructor stub
	}
	
	public String showAffection() {
		return getName() + " looked up at you!";
	}

}
