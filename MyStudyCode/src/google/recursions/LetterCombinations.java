package google.recursions;

import java.util.ArrayList;
import java.util.List;


public class LetterCombinations {
    public void backtrack(int idx, String[] letters, String digits, StringBuilder temp, List<String> result){
        if(temp.length() == digits.length()) result.add(temp.toString()); // Step 1
        else {
            char[] letterArr = letters[digits.charAt(idx) - '2'].toCharArray(); // Step 2 & 3
            for(int j = 0; j < letterArr.length; j++){
                temp.append(letterArr[j]); // Step 4
                backtrack(idx + 1, letters, digits, temp, result); // Step 4
                temp.deleteCharAt(temp.length() - 1); // Step 5
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList(); // Step 1
        if(digits.length() == 0) return result; // Step 1
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; // Step 2
        backtrack(0, letters, digits, new StringBuilder(), result); // Step 3
        return result; // Step 4
    }

  public static void main(String[] args) {
    LetterCombinations letterCombinations = new LetterCombinations();
    System.out.println(letterCombinations.letterCombinations("23"));
  }
}
