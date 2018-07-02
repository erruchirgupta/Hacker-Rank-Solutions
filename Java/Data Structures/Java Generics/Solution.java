//     Author: Ruchir Gupta
//     Github: https://github.com/erruchirgupta
// HackerRank: https://hackerrank.com/RuchirGupta

import java.io.IOException;
import java.lang.reflect.Method;

class Printer
{
    /*public void printArray(Object [] arrObjects) {
        for(Object obj : arrObjects){
            if(obj instanceof Integer)
                System.out.println(String.valueOf(((Integer) obj).intValue()));
            else
                System.out.println((String) obj);
        }
    }*/
    
    public <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }
 
}
public class Solution {

    public static void main( String args[] ) {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)System.out.println("Method overloading is not allowed!");
      
    }
}
