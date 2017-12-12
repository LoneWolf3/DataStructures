package com.sac.tough;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 07/20/2015
 * @author Tushar Roy
 *
 * Given a list of list of Strings. Print cartesian product of lists.
 * input -> {"Hello", "World"} , {"Game"}, {"Go","Home"}
 * output ->
 * Hello Game Go
 * Hellow Game Home
 * World Game Go
 * World Game Home
 */
public class WordCombination000 {

    public void printCombinations(List<List<String>> input) {
        int[] result = new int[input.size()];
        print(input,result, 0);
    }

    private void print(List<List<String>> input, int[] result, int pos) {

        if(pos == result.length){
            for (int i = 0; i < input.size(); i++) {
                System.out.print(input.get(i).get(result[i]) + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i < input.get(pos).size(); i++){
            result[pos] = i;
            print(input,result, pos+1);
            System.out.println(pos);

        }
    }

    public static void main(String args[]){
        List<String> l1 = new ArrayList();
        l1.add("Hello");
        l1.add("World");

        List<String> l2 = new ArrayList();
        l2.add("Game");
       

        List<String> l3 = new ArrayList();
        l3.add("Go");
        l3.add("Home");

        List<List<String>> input = new ArrayList();
        input.add(l1);
        input.add(l2);
        input.add(l3);

        WordCombination000 wc = new WordCombination000();
        wc.printCombinations(input);

    }
}
