import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HelloJoy {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append('\n').append(" ").append('\n').append(" ").append('\n').append(" ");
//        sb.append('\n').append('\n');
//        System.out.println(sb.toString());
//        String[] te = sb.toString().split("\n");
//        System.out.println(te.length);

        String an = sb.toString().trim().replaceAll("(?m)^[ \t]*\r?\n", "");;
        List<String> uploadListValues = new ArrayList<>(Arrays.asList(an.split("\n")));
        uploadListValues = uploadListValues.stream().map(value -> value.trim()).collect(Collectors.toList());
        System.out.println(uploadListValues.get(0).equals(""));

        String[] customListValues = {
                "Values",
                "three",
                "four",
                "five",
                "six"
        };

        System.out.println(customListValues.toString().getBytes());
    }
}
