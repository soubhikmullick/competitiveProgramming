package java_concepts.Java8;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueuesImpl {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(20);
        minHeap.add(30);
        minHeap.add(40);
        minHeap.add(50);
        minHeap.add(60);
        minHeap.add(10);
        minHeap.forEach(s -> System.out.println(s));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(20);
        maxHeap.add(30);
        maxHeap.add(40);
        maxHeap.add(50);
        maxHeap.add(60);
        maxHeap.add(10);
        maxHeap.forEach(s -> System.out.println(s));
    }
}
