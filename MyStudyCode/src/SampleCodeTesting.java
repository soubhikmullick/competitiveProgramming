import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

abstract class Tesddt {
  public void getData() {
    System.out.println("abstract");
  }
}



public class SampleCodeTesting extends Tesddt{

  public static String[] string = new String[] {
          "",
          "",
          "abc",
          "def",
          "ghi",
          "jkl",
          "mno",
          "pqrs",
          "tuv",
          "wxyz",
          "*+",
          "#"};

  public static void letterCombinationsHelper(String digits, List<String> ans, StringBuilder sb) {
    int len = sb.length();
    if(digits.length() == len) {
      ans.add(sb.toString());
      return;
    }

    for(char ch: string[len].toCharArray()){
      sb.append(ch);
      letterCombinationsHelper(digits, ans, sb);
      sb.setLength(len);
    }


  }

  public static List<String> letterCombinations(String digits) {
    if(digits.length() == 0) {
      return new ArrayList<String>();
    }
    List<String> ans = new ArrayList<String>();
    letterCombinationsHelper(digits, ans, new StringBuilder());
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(letterCombinations("23"));
  }

}
