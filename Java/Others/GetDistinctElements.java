//     Author: Ruchir Gupta
//     Github: https://github.com/erruchirgupta
// HackerRank: https://hackerrank.com/RuchirGupta

import java.util.*;
import java.lang.*;
import java.io.*;

/* 
Online Judge solution
https://ideone.com/V8lupV

------- For Input 1 ------
arr1 [1,2,3,4,5]
arr2 [4,5,4,6,7]
distincts are [1,2,3,6,7] , Size = 5

------- For Input 2 ------
arr1 [1,2,3,4,4,5]
arr2 [4,5,4,6,7]
distincts are [1,2,3,6,7] , Size = 5

------- For Input 1 ------
arr1 [1,2,3,4,5,6,7,8,9,10]
arr2 [11,12,6,7,8,9,13,14]
distincts [1,2,3,4,5,10,11,12,13,14] , Size = 10
*/

public class GetDistinctElements
{
   public static void getDistinct(int arr1[], int arr2[]) {
   	
         HashSet <Integer> hs = new HashSet<Integer>();
         HashSet <Integer> hsTotal = new HashSet<Integer>();
		
         for(int i=0; i<arr1.length; i++){
         	hs.add(arr1[i]);
         	hsTotal.add(arr1[i]);
         }

         for(int i=0; i<arr2.length; i++)
            hsTotal.add(arr2[i]);
         
         for(int i=0; i<arr2.length; i++){
         	if(hs.contains(arr2[i]))
         	   hsTotal.remove(arr2[i]);
         }
         
         System.out.println(hsTotal.size());
         
         /*for(int i : hsTotal) 
         	System.out.println(i);*/
   }
   public static void main (String[] args) throws Exception
      {
         // your code goes here
         int arr1 [] = {1,2,3,4,5};
         int arr2 [] = {4,5,4,6,7};
         
         getDistinct(arr1,arr2);

         arr1 = new int[] {1,2,3,4,4,5};
         arr2 = new int[] {4,5,4,6,7};
         
         getDistinct(arr1,arr2);
         
         arr1 = new int[] {1,2,3,4,5,6,7,8,9,10};
         arr2 = new int[] {11,12,6,7,8,9,13,14};
         
         getDistinct(arr1,arr2);
            
      }
}
