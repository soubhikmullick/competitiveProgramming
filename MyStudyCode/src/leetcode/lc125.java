package leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.stream.Collectors;
import com.sun.xml.internal.ws.util.StringUtils;


public class lc125 {

    public static int recur(int target, int ans, int pos, int speed, HashMap<String, Integer> map) {
        if(target == pos) {
            return ans;
        }
        if (pos < 0 || pos > target * 2) {
            return Integer.MAX_VALUE; // Return a large value to indicate no solution
        }
        if(map.containsKey(pos+" "+speed)) return map.get(pos+" "+speed);
        map.put(pos+" "+speed, ans);
        int op1 = recur(target, ans++, pos+speed, speed*2, map);
        int op2 = recur(target, ans++, pos, speed>0?-1:1, map);
        return Math.min(op1, op2);
    }
    public static int recusr(int target, int ans, int pos, int speed) {
        if(target == pos) {
            return ans;
        }
        if (pos < 0 || pos > target * 2) {
            return Integer.MAX_VALUE; // Return a large value to indicate no solution
        }
        int op1 = recusr(target, ans++, pos+speed, speed*2);
        int op2 = recusr(target, ans++, pos, speed>0?-1:1);
        return Math.min(op1, op2);
    }
    public static void main(String[] args) {
//        List<Object> objects = new ArrayList<>();
//        objects.add("VAL");
        Object obj = new Object();
        obj="asdf";
        Map<String, String> accountMap =
                (HashMap<String, String>) obj;
        System.out.println(accountMap);
        System.out.println("hello");
    }
}
