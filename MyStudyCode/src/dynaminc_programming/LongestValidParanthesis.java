package dynaminc_programming;

import java.io.FileNotFoundException;
import java.util.Stack;

public class LongestValidParanthesis {
    public static void main(String[] args) throws FileNotFoundException {
        String s = "))(()";
        Stack stack = new Stack();
        int count = 0;
        char[] charArr = s.toCharArray();
        for(char c : charArr) {
            if(c == '(') stack.push(c);
            else if(!stack.isEmpty() && (char) stack.peek() == '('){
                stack.pop();
                count++;
            }
        }
        System.out.println(count*2);
    }
}
