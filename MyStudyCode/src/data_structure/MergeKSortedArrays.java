package data_structure;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        Integer[][] arr = {{1,2,3}, {3,4,5}, {1,2,3,4,5}};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i<arr.length; i++) {
            List<Integer> val = Arrays.asList(arr[i]);
            priorityQueue.addAll(val);
        }
        System.out.println(priorityQueue);
    }
}
