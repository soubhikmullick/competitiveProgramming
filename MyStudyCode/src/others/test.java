package others;

import java.util.HashSet;

public class test {

    test() {
        System.out.println("2");

    }

    {
        System.out.println("1");
    }



    static {
        System.out.println("55");
    }

    public static void main(String[] args) {
        test s = new test();
        test d = s;
        test a = d;
//        System.out.println(a==s);

        HashSet<String> hs = new HashSet<>();
        hs.add("test");
        System.out.println(hs.contains("test"));
    }

}