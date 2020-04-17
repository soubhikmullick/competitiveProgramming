package java_concepts.Java8;

import java.util.PriorityQueue;

public class PriorityQueuesImpl {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(20);
        priorityQueue.add(30);
        priorityQueue.add(40);
        priorityQueue.add(50);
        priorityQueue.add(60);
        priorityQueue.add(10);
        priorityQueue.forEach(s -> System.out.println(s));
    }
}
