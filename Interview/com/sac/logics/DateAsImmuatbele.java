package com.sac.logics;

/**
 * http://www.yegor256.com/2014/06/09/objects-should-be-immutable.html
 * Temporal coupling example
 * null reference
 * thread safe
 * 
 */
public class DateAsImmuatbele {

	
	static MutableClass mb = new MutableClass();

	public static void main(String[] args) {
		String s1 = null;
		mb.setName("B");
		s1 = mb.getName();
		String s2 = "A".concat(s1);
		System.out.println(s2);

		// s1 = mb.setName("s1").getName();
		s2 = "A".concat(mb.setName("B").getName());
		System.out.println(s2);
	}

}

class MutableClass {

	private String name;

	MutableClass(String name) {
		this.name = name;
	}

	public MutableClass() {
	}

	public String getName() {
		return name;
	}

	// this setter can modify the name
	public MutableClass setName(String name) {
		this.name = name;
		return this;
	}
}
