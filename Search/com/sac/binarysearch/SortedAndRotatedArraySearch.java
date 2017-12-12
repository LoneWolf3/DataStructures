package com.sac.binarysearch;

/**
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * This does not works if there are duplicates in the array.
 */
public class SortedAndRotatedArraySearch {

    public int search(int arr[],int key){
        
        int low =0;
        int high = arr.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == key){
                return mid;
            }
            
            if(arr[mid] < arr[high]){
                if(arr[mid] < key && key <= arr[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }else{
                if(key >= arr[low] && key < arr[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String args[]){
        SortedAndRotatedArraySearch ras = new SortedAndRotatedArraySearch();
        int arr1[] = {5,6,1,2,3,4};
        System.out.print(ras.search(arr1, 2));
       
    }
}
