package others;

import java.util.*;

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

    }

}