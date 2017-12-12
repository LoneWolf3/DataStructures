package com.sac.misc.learnt;

import java.util.Stack;

/**
 * You can use stack, start pushing each character from input string till you
 * not hit close parenthesis. When you hit close parenthesis, start pop the
 * element till you not hit open parenthesis. If the immediate pop hit open
 * parenthesis than that is duplicate parenthesis. Note: this algo will fail, if
 * one put false parenthesis in string like: () .... Code as:
 * 
 * @author ssachdev
 * 
 */
public class RemoveDupParanthese {
	public static void main(String[] args) {
		System.out.println(FindDuplicateparenthesis("((a+b))+((c+d))").toString());
	}

	public static Stack<Character> FindDuplicateparenthesis(String input) {
		Stack<Character> inputStack = new Stack<Character>();
		for (char inputChar : input.toCharArray()) {
			if (inputChar != ')') {
				inputStack.push(inputChar);
			} else {
				char popChar = (Character) inputStack.pop();
				if (popChar == '(')
					System.out.println("Duplicate Find ");
				else {
					while (popChar != '(') {
						popChar = (Character) inputStack.pop();
					}
				}
			}
		}
		return inputStack;
	}
}
