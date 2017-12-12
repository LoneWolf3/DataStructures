package com.sac.tough;

import java.util.*;

public class RemoveInvalidParenthesis000 {
    
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> candidates = new LinkedList<String>();
        List<String> results = new ArrayList<String>();
        s = preprocessing(s);
        if(s.equals("")) {
            results.add("");
            return results;
        }
        
        //The overall idea is just to remove one character each time, if after removing, the number of mismatch is going down,
        //then put this new expression into a new queue. If after removing, the new expression is a valid expression, then we
        //find the result with the minimum removing steps. After processsing the remainder elements in the current queue, we
        //can return the results.
        candidates.add(s);
        while(!candidates.isEmpty()) {
            Queue<String> candidates2 = new LinkedList<String>();
            //Using a set to remove the duplicates will expediate the process dramatically.
            Set<String> candidateSet = new HashSet<>();
            boolean valid = false;
            while(!candidates.isEmpty()) {
                String cur = candidates.poll();
                if(findNumMisMatch(cur) == 0) {
                    results.add(cur);
                    if(valid == false)
                        valid = true;
                } else {
                    for(int i = 0; i < cur.length(); i++) {
                        if(i != 0 && cur.charAt(i) == cur.charAt(i - 1))
                            continue;
                        StringBuilder newSB = new StringBuilder(cur.substring(0, i));
                        if(i != cur.length() - 1)
                            newSB.append(cur.substring(i+1));
                        String newS = newSB.toString();
                        if(!candidateSet.contains(newS) && findNumMisMatch(newS) < findNumMisMatch(cur)) {
                            candidateSet.add(newS);
                            candidates2.add(newS);
                        }
                    }
                }
            }
            if(valid == true)
                return results;
            candidates.addAll(candidates2);
        }
        return results;
    }

    //This function is used to evaluate whether an expression is valid. If it returns 0, the expression is valid.
    //It can also give the number of elements need to be removed to make a valid expression.
    public int findNumMisMatch(String s) {
        int numLeft = 0, numRight = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                numLeft++;
            } else if(s.charAt(i) == ')') {
                if(numLeft == 0) {
                    numRight++;
                } else {
                    numLeft--;
                }
            }
        }
        return numLeft + numRight;
    }
    
    //Remove the trailing ")"s in the front and the tailing "("s, because these parentheses must be removed to make a valid 
    //expression. 
    public String preprocessing(String s) {
        StringBuilder sb = new StringBuilder();
        boolean leftAppear = false;
        int i = 0;
        while(!leftAppear && i < s.length()) {
            if(s.charAt(i) == '(') {
                leftAppear = true;
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i) == ')') {
                i++;
                continue;
            }
            else {
                sb.append(s.charAt(i));
            }
            i++;
        }
        s = sb.append(s.substring(i)).toString();
        sb = new StringBuilder();
        boolean rightAppear = false;
        i = s.length() - 1;
        while(!rightAppear && i >= 0) {
            if(s.charAt(i) == ')') {
                rightAppear = true;
                sb.insert(0, s.charAt(i));
            }
            else if(s.charAt(i) == '(') {
                i--;
                continue;
            }
            else {
                sb.insert(0, s.charAt(i));
            }
            i--;
        }
        return sb.insert(0, s.substring(0, i+1)).toString();
    }


	public static void main(String args[]) {

		String s = "(()";
		RemoveInvalidParenthesis000 rmp = new RemoveInvalidParenthesis000();
		List<String> result = rmp.removeInvalidParentheses(s);
		result.forEach(s1 -> System.out.println(s1));
	}
}
