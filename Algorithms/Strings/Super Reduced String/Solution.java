import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    // Complete the super_reduced_string function below.
    static String super_reduced_string(String s) {
        
        int c = 0;
        String curr = s;
        String prev = s;
        
        while((curr!=null && curr.length() > 1) && !(curr.equals(prev) && c+1 == curr.length())) {
            
            if(curr.charAt(c) == curr.charAt(c+1)) { 
                curr=curr.replace(curr.substring(c,c+2),"");
                c=0;
            } else if (curr.equals(prev)) {
                c++;
            }
            prev = curr;            
        }
            
        if(curr == null || curr.equals(""))
            return "Empty String";
        else
            return curr;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = super_reduced_string(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
