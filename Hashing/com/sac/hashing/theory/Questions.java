package com.sac.hashing.theory;

import java.util.HashMap;
import java.util.Map;

public class Questions {
	/**
	 * 
	 * How java handles collisoins . collision resolution techniques. Load
	 * factor why re hashing required what is race condition
	 */

	public static void main(String[] args) {
		Map m = new HashMap();
		m.put("1", "one");
		m.put("1", "two");
		System.out.println(m.toString());
	}
}
