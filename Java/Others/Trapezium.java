//     Author: Ruchir Gupta
//     Github: https://github.com/erruchirgupta
// HackerRank: https://hackerrank.com/RuchirGupta

import java.util.*;
import java.lang.*;
import java.io.*;

/* 
Online Judge solution
https://ideone.com/gZJkGU

------- For Input = 4 ------
1*2*3*4*17*18*19*20
--5*6*7*14*15*16
----8*9*12*13
------10*11

------- For Input = 3 ------
1*2*3*10*11*12
--4*5*8*9
----6*7
*/
public class Trapezium
{
    public static void pattern(int n) {
      
      int c=1;
      for(int i=n; i>0; i--) {

          for(int k=1; k<=n-i; k++)
            System.out.print("--");

            String next = "";

          for(int j=1; j<=i; j++) {
            System.out.print((c++)+"*");
            
            int val = i*i+c-1;
            next+=val+"*";
          }
            System.out.println(next.substring(0,next.length()-1));
      }
      
    }

    public static void main (String[] args) throws java.lang.Exception {
      pattern(4);
      System.out.println("-------------");
      pattern(3);
    }
}
