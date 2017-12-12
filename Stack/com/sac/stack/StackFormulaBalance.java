package com.sac.stack;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class StackFormulaBalance {
    static Map<Character, Character> brackets = new HashMap<Character, Character>() ;

    public static void main(String[] args) {
		System.out.println(balance("(a[b{c)d]e"));
	}
    
    public static  boolean balance(String toBalance) {
        Deque<Character> bracketsStack = new ArrayDeque<Character>();
        for (int i = 0; i < toBalance.length(); i++) {
            char currentChar = toBalance.charAt(i);
            if (characterIsOpenBracket(currentChar)) {
                bracketsStack.push(currentChar);
            } else if (characterIsAClosingBracket(currentChar) &&
                    closingBracketMatchesLastOpeningBracket(bracketsStack, currentChar)) {
                return false;
            }
        }
        return bracketsStack.isEmpty();
    }

    private static boolean closingBracketMatchesLastOpeningBracket(Deque<Character> bracketsStack, char currentChar) {
        return bracketsStack.size() == 0 || !brackets.get(bracketsStack.pop()).equals(currentChar);
    }

    private static boolean characterIsAClosingBracket(char currentChar) {
        return brackets.values().contains(currentChar);
    }

    private static boolean characterIsOpenBracket(char currentChar) {
        return brackets.containsKey(currentChar);
    }
}