package com.array;

public class Interchange {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 }; // get 1 5 2 6 3 7 4 8 
		int[] newarr = new int[nums.length];
		int count = 0, m = 0;
		//Need to iterate over half beacuse with each shift we are moving last to first.
		for (int i = 0; i < nums.length / 2; i++) {
			//assign first to new array
			newarr[count] = nums[i];
			//increase count by two. so that 3d elemnt can be placed.
			count += 2;
			//assign last to second.
			newarr[count - 1] = nums[nums.length / 2 + i];
		}
		for (int i = 0; i < newarr.length; i++)
			System.out.print(newarr[i] + " ");
	}

}
