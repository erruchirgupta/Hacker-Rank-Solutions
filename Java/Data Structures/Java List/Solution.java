//     Author: Ruchir Gupta
//     Github: https://github.com/erruchirgupta
// HackerRank: https://hackerrank.com/RuchirGupta

import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        ArrayList<Integer> arList = new ArrayList<Integer>();
        
        for(int i=0; i<n; i++){
            arList.add(scanner.nextInt());
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        }
        
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        while(q-- != 0) {
            String task = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            String input = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            String in [] = input.split(" ");
            
            if(task.equalsIgnoreCase("Insert")) {
                arList.add(Integer.parseInt(in[0]),Integer.parseInt(in[1]));
            } 
            else if (task.equalsIgnoreCase("Delete")) {
                arList.remove(Integer.parseInt(in[0]));
            }
        }
        
        for(int x : arList){
            System.out.print(x+" ");
        }
            
    }
}