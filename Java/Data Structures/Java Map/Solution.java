//     Author: Ruchir Gupta
//     Github: https://github.com/erruchirgupta
// HackerRank: https://hackerrank.com/RuchirGupta

import java.util.*;
import java.io.*;

public class Solution {
    
    private static final Scanner scanner = new Scanner(System.in);
    
	public static void main(String [] args)
	{
		int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        HashMap <String,Integer> map = new HashMap <String,Integer>();
        
		for(int i=0; i<n; i++)
		{
			String name = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
			Integer phone = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            map.put(name,phone);
		}
		while(scanner.hasNext())
		{
			String input = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            if(map.containsKey(input))
                System.out.println(input+"="+map.get(input));
            else
                System.out.println("Not found");
            
		}
	}
}