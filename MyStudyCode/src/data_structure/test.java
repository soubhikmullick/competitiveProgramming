package data_structure;

import java.util.ArrayList;
import java.util.List;


public class test {
    public Object val() {
        return null;
    }

    // Java program for the above approach

    // Function to count the number of
    // possible numbers divisible by 3
    public static void findCount(String number) {

        // Calculate the sum
        int sum = 0;
        for (int i = 0; i < number.length(); ++i) {
            sum += number.charAt(i) - 48;
        }

        // Store the answer
        int count = 0;
        if (sum % 3 == 0) {
            count++;
        }

        // Iterate over the range
        for (int i = 0; i < number.length(); ++i) {

            // Decreasing the sum
            int remaining_sum
                    = sum - (number.charAt(i) - 48);

            // Iterate over the range
            for (int j = 0; j <= 9; ++j) {

                // Checking if the new sum
                // is divisible by 3 or not
                if ((remaining_sum + j) % 3 == 0
                        && j != number.charAt(i) - 48) {

                    // If yes increment
                    // the value of the count
                    ++count;
                }
            }
        }
        System.out.println(count);
    }

    public static int findCsount(String S) {
        int sum = 0;
        for (int i = 0; i < S.length(); i++) {
            sum += S.charAt(i) - '0';
        }

        int finalAnswer = 0;
        if (sum % 3 == 0) {
            finalAnswer++;
        }

        for (int i = 0; i < S.length(); i++) {
            int remainingSum = sum - (S.charAt(i) - '0');
            for (int j = 0; j <= 9; j++) {
                if ((remainingSum + j) % 3 == 0 && j != S.charAt(i) - '0') {
                    finalAnswer++;
                }
            }
        }
        return finalAnswer;
    }


    // Driver Code
    public static void main(String[] args) {
        // Given number
        test tesst = new test();

        if (tesst.val().equals(null)) {
            System.out.printf("Yo");
        }

//        findCsount(number);
    }
}



