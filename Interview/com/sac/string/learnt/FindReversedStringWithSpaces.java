package com.sac.string.learnt;
/**
 * Algo
 * temp = String.valueOf(input.charAt(0));
 * if space found
 * out = out + temp +''
 * temp = ""
 * 
 * else
 * temp = input.chat(1) + temp
 * @author ssachdev
 *
 */
public class FindReversedStringWithSpaces {
public static void main(String[] args) {
	

	System.out.println(reverse("Iam a human being"));
}



	public static String reverse(String input){
		if(input == null){
			return null;
		}		
		String output = "";
		String tmp = String.valueOf(input.charAt(0));
		for(int i = 1; i < input.length(); i++){
			if(input.charAt(i) ==' '){
				output = output + tmp + ' ';
				tmp = "";
			}else{
				tmp = input.charAt(i) + tmp;
			}
		}
                //Append last word
		output = output  + ' ' + tmp;
		return output;
	}
}
