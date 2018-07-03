//     Author: Ruchir Gupta
//     Github: https://github.com/erruchirgupta
// HackerRank: https://hackerrank.com/RuchirGupta

import java.util.*;

// ArrayDeque is "likely to be faster than Stack when used as a stack"

class Solution {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    private static boolean isBraceBalanced(String exp, HashMap<Character,Character> map) {
        
        if(exp == null || (exp != null && exp.length()%2 != 0))
           return false; //odd length Strings are not balanced
        
        ArrayDeque <Character> deque = new ArrayDeque <>(); // use deque as a stack
        
        for(int i=0; i<exp.length(); i++) {
            Character ch = exp.charAt(i);
            
            if(map.containsKey(ch))
                deque.push(ch); // pushing starting braces as keys in stack
            else if (deque.isEmpty() || ch != map.get(deque.pop()))
                return false;
        }
        return deque.isEmpty();        
    }
	
    public static void main(String [] arg) {
	/* Create HashMap to match opening brackets with closing brackets */
	
	HashMap<Character,Character> map = new HashMap<>();
	map.put('(',')');
	map.put('{','}');
	map.put('[',']');
        
	Scanner scanner = new Scanner(System.in);
	/* Test each expression for validity */
	while (scanner.hasNext()) {
		String exp = scanner.next();
      		System.out.println(isBraceBalanced(exp,map) ? "true" : "false");
	}
	scanner.close();
	}
}
