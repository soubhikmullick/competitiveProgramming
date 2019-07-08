package CTCI;

import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int disks = 3;
        Stack<Integer> source = new Stack<>();
        Stack<Integer> buffer = new Stack<>();
        Stack<Integer> destination = new Stack<>();

        for (int i = disks; i > 0; i--) {
            source.push(i);
        }
        printTower(source);
        printTower(destination);
        moveDisks(disks, source, destination, buffer);
        printTower(source);
        printTower(destination);
    }

    private static void moveDisks(int disks, Stack<Integer> source, Stack<Integer> destination, Stack<Integer> buffer) {
        if(disks<=0) return;
        moveDisks(disks-1, source, buffer, destination);
        moveDiskFromTo(source, destination);
        moveDisks(disks-1, buffer, destination, source);
    }

    private static void moveDiskFromTo(Stack<Integer> source, Stack<Integer> destination) {
        int disk = source.pop();
        destination.push(disk);
    }

    private static void printTower(Stack<Integer> s) {
        for(int stack : s) {
            System.out.println(stack);
        }
        System.out.println();
    }


}
