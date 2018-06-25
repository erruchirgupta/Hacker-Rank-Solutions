//     Author: Ruchir Gupta
//     Github: https://github.com/erruchirgupta
// HackerRank: https://hackerrank.com/RuchirGupta

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    public static void findMaxSum(int arr[][]){
        
        int r = 6, c = 6;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i< r-2; i++) {
            sum = 0;
            for(int j=0; j<c-2; j++) {
                sum = (arr[i+0][j] + arr[i+0][j+1] + arr[i+0][j+2]
                                   + arr[i+1][j+1]
                      +arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]);
                
                max = Math.max(max,sum);
            }            
        }
     System.out.println(max);   
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        
        findMaxSum(arr);

        scanner.close();
    }
}
