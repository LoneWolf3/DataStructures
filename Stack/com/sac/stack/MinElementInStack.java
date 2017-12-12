package com.sac.stack;

public class MinElementInStack {
	/**
	 * Maintain another stack and keep pushing the min element on the stack as
	 * in when found. Before each push on stack 1, just check if the current
	 * element is less than the top element of second stack if yes then push it
	 * on to stack 2.
	 * 
	 * While poping an element from stack1 check if the top of stack2 is same as
	 * the element in that case pop both the elements so that next min would
	 * show up on stack 2 for next min operation.
	 * 
	 * 
	 * 
	 * This would ensure that we pop out the min element in o(1) time
	 */
}
