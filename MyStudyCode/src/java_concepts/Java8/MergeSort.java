package java_concepts.Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>((Arrays.asList("water", "air", "fire", "soil", "life", "air")));
        int low = 0, high = input.size() - 1;
        System.out.println(input);
        merge(input, low, high);

    }

    public static void merge(List<String> input, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            merge(input, low, mid);
            merge(input, mid + 1, high);
            System.out.println(input + " low="+low+" mid="+mid+" high="+high);
            sort(input, low, mid, high);
            System.out.println(input + " low="+low+" mid="+mid+" high="+high);
            System.out.println();
        }
    }

    public static void sort(List<String> input, int low, int mid, int high) {
        List<String> leftArray = new ArrayList<>();
        List<String> rightArray = new ArrayList<>();

        for (int i = low; i <= mid; i++) {
            leftArray.add(input.get(i));
        }
        for (int i = mid+1; i <= high; i++) {
            rightArray.add(input.get(i));
        }
        int i = 0; int j = 0, k=low;
        while(i<leftArray.size() && j<rightArray.size()) {
            if(leftArray.get(i).compareTo(rightArray.get(j))<=0) {
                input.remove(k);
                input.add(k++,leftArray.get(i++));
            } else {
                input.remove(k);
                input.add(k++,rightArray.get(j++));
            }
        }
        while(i<leftArray.size()) {
            input.remove(k);
            input.add(k++,leftArray.get(i++));
        }
        while(j<rightArray.size()) {
            input.remove(k);
            input.add(k++,rightArray.get(j++));
        }
    }
}

// 4 1 2 5

// 2 5 -> 2 5

// 2 5 1 -> (2 5) (1) - (1 2 5)
// (1 2 5)