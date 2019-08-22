import java.math.BigDecimal;
import java.util.*;

public class test {

    {
        System.out.println("1");
    }
    test(){
        System.out.println("2");

    }
    static {
        System.out.println("55");
    }

    public static void main(String[] args) {

       String s = "1231";
        System.out.println(s.length());
        char[] test = new char[]{'p','e','r','f','e','c','t',' ','m','a','k','e','s',' ','p','r','a','c','t','i','c','e'};

    }

    public static void setBigDecimal(BigDecimal b) {
        b = b.add(new BigDecimal("10"));
    }

    static class A {
        String a = null;
        A(String a) {
            this.a = a;
        }
        public String get(){return a;}
    }

}