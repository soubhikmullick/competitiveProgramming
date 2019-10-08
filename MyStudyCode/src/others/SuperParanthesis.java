package others;

import java.util.Scanner;
import java.util.Stack;

public class SuperParanthesis {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        Stack s = new Stack();
        while(t-->0) {
            int count = 0;
            int maxSum = 0;
            String query = in.next();
            for(char ch : query.toCharArray()) {
//                if(ch == '(') {
//                    s.push(ch);
////                    count = 0;
//                }
//                else {
//                    if(!s.isEmpty() && s.peek().equals('(')){
//                        count++;
//                        s.pop();
//                        maxSum = maxSum<count?count:maxSum;
//                    } else {
//                        maxSum = maxSum<count?count:maxSum;
//                        count = 0;
//                    }
//                }
                if(ch == ')') {
                    count++;
                } else {
                    maxSum = maxSum<count?count:maxSum;
                    count = 0;
                }
            }
            System.out.println(maxSum*2);
        }
    }
}
