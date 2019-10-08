package data_structure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FormMaxNumberFromGivenArray {
    public static void main(String[] args) {
//        String[] num = {"123", "2", "5", "9", "42"};
        String[] num = {"54", "546", "548", "60"};
        List<String> strings = Arrays.asList(num);
        Collections.sort(strings, (o1, o2) -> {
            String o1o2 = o1+o2;
            String o2o1 = o2+o1;
            return o2o1.compareTo(o1o2);
        });
        StringBuilder sb = new StringBuilder();
        for(String s : strings) {
            sb.append(s);
        }

        System.out.println(sb.toString());
    }
}
