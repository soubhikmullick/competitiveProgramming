package java_concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ExecutionOrder {

    ExecutionOrder() {
        System.out.println("constructor");
    }

    {
        System.out.println("block2");
    }

    static {
        System.out.println("static");
    }


    {
        System.out.println("block1");
    }

    public static void main(String[] args) {
        System.out.println("main");
        ExecutionOrder eo = new ExecutionOrder();
        System.out.println("Apple".compareTo("Banana"));
        Object obj;
    }
}
