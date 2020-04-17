package data_structure;

public class SortingWindowOfArray {
    public static void main(String[] args) {
        int[] input = {1,3,2,7,5,6,4,8};
        int smallest = input[input.length-1];
        int largest = input[1];
        int lastIndex = 0;
        int startIndex = 0;
        for (int i = 1; i < input.length; i++) {
            if(largest > input[i]) {
                lastIndex = i;
            } else {
                largest = input[i];
            }
            System.out.println("lastIndex"+lastIndex+" largest"+largest);
        }
        System.out.println("------------------------------------------");
        for (int i = input.length-2; i > 0; i--) {
            if(smallest < input[i]) {
                startIndex = i;
            } else {
                smallest = input[i];
            }
            System.out.println("startIndex"+startIndex+" smallest"+smallest);
        }

        System.out.println(startIndex+""+lastIndex);
    }
}
