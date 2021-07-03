package data_structure.trees;

import java.util.Map;
import java.util.TreeMap;

public class BottomView {
    // A class to store a binary tree node
    static class Node {
        int key;
        Node left = null, right = null;

        Node(int key) {
            this.key = key;
        }
    }

    public static void printBottom(Node root, int dist,
                                   Map<Integer, Integer> map) {
        // base case: empty tree
        if (root == null) {
            return;
        }

        map.put(dist, root.key);
        printBottom(root.left, dist - 1, map);
        printBottom(root.right, dist + 1, map);
    }

    // Function to print the bottom view of a given binary tree
    public static void printBottom(Node root) {
        /* Create a `TreeMap` where
        `key` —> relative horizontal distance of the node from the root node, and
        `value` —> pair containing the node's value and its level */

        Map<Integer, Integer> map = new TreeMap<>();

        // perform preorder traversal on the tree and fill the map
        printBottom(root, 0, map);

        // traverse the `TreeMap` and print the bottom view
        for (Map.Entry<Integer, Integer> es : map.entrySet()) {
            System.out.println(es.getKey() + " " + es.getValue());
        }
    }

    public static void main(String[] args) {
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.right = new Node(4);
//        root.right.left = new Node(5);
//        root.right.right = new Node(6);
//        root.right.left.left = new Node(7);
//        root.right.left.right = new Node(8);

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        printBottom(root);
    }
}
