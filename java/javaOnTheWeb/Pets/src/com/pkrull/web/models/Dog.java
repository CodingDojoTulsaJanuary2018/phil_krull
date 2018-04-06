package com.pkrull.web.models;

public class Dog extends Animal implements Pet {

	public Dog() {
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, String breed, double weight) {
		super(name, breed, weight);
		// TODO Auto-generated constructor stub
	}
	
	public String showAffection() {
		String rStr;
		if(getWeight() < 30) {
			rStr = "hopped in your lap";
		} else {
			rStr = "currled up next to you";
		}
		return rStr;
	}

}
