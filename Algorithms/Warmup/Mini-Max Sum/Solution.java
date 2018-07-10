import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the miniMaxSum function below.
    
    static void miniMaxSum(int[] arr) {
        
        long sum=0,min=Long.MAX_VALUE,max=Long.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
            sum+=arr[i];
        for(int i=0; i<arr.length; i++) {
            if(sum-arr[i] < min)
                min = sum-arr[i];
            if(sum-arr[i] > max)
                max = sum-arr[i];
        }
        System.out.println(min+" "+max);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
