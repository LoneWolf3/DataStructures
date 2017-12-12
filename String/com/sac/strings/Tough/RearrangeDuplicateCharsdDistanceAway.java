package com.sac.strings.Tough;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class RearrangeDuplicateCharsdDistanceAway {
//Implementing comprator so that 
    class CharCount implements Comparable<CharCount>{
        char ch;
        int count;
        
        @Override
        public String toString() {
            return "CharCount [ch=" + ch + ", count=" + count + "]";
        }
        @Override
        public int compareTo(CharCount cc) {
            if(this.count >= cc.count){
                return -1;
            }else{
                return 1;
            }
        }
        
    }
    
    public boolean rearrangeExactKDistanceAway(char input[],int d){
        PriorityQueue<CharCount> heap = new PriorityQueue<CharCount>();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        //=====Create a Map that has count of each charcter=====
        for(int i=0; i < input.length; i++){
            int count = 1;
            if(map.containsKey(input[i])){
                count = map.get(input[i]);
                count++;
            }
            map.put(input[i], count);
            input[i] = 0;
        }
        //======================================
        
        
        //add charcter in a heap.
        for(Character ch : map.keySet()){
            CharCount cc = new CharCount();
            cc.ch = ch;
            cc.count = map.get(ch);
            heap.add(cc);
        }
        
        //Iterate over heap and add charcter in array at disitance d apart
        while(heap.size() > 0){
            CharCount cc = heap.poll();
            int i;
            for(i=0; i < input.length && input[i] != 0; i++);
            if(i == input.length){
                return false;
            }
            while(cc.count > 0 && i < input.length){
                input[i] = cc.ch;
                i = i + d;
                cc.count--;
            }
            if(cc.count > 0){
                return false;
            }
        }
        return true;
    }
    
    private void getAllFeasibleCharacters(char output[], int k,int pos,Set<Character> allChars){
        for(int i = pos-1; i > pos -k && i >=0; i--){
            allChars.remove(output[i]);
        }
    }
    
    public boolean rearrangeAtleastkDistanceAway(char input[],int k){
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0; i < input.length; i++){
            int count = 1;
            if(map.containsKey(input[i])){
                count = map.get(input[i]);
                count++;
            }
            map.put(input[i], count);
            input[i] = 0;
        }
        return rearrangeAtleastkDistanceAway(map, input, 0, k);
    }
    
    public boolean rearrangeAtleastkDistanceAway(Map<Character,Integer> charCount,char output[],int pos,int k){
        if(pos == output.length && charCount.size() == 0){
            return true;
        }
        Set<Character> allChars = new HashSet<Character>();
        for(char ch : charCount.keySet()){
            allChars.add(ch);
        }
        getAllFeasibleCharacters(output,k,pos,allChars);
        for(char ch : allChars){
            output[pos] = ch;
            int c = charCount.get(ch);
            if(c -1 == 0){
                charCount.remove(ch);
            }else{
                charCount.put(ch, c-1);
            }
            boolean r = rearrangeAtleastkDistanceAway(charCount, output, pos+1, k);
            if(r){
                return true;
            }
            charCount.put(ch, c);
        }
        return false;
    }
    
    public static void main(String args[]){
        String str = "aacbbc"; 
        char input[] = str.toCharArray();
        RearrangeDuplicateCharsdDistanceAway rdc  =new RearrangeDuplicateCharsdDistanceAway();
        boolean r =rdc.rearrangeExactKDistanceAway(input, 3);
        if(r){
            for(char ch : input){
                System.out.print(ch + " ");
            }
        }else{
            System.out.println("Not possible");
        }
    }
    
}
