package data_structure.trees;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class PrintAllCousins {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printAllCousins(root, root.left.right);
    }

    private static void printAllCousins(Node root, Node node) {
        if(root == null) return;
        int level = findLevel(root, node, 0, 1);
        if(level == -1) System.out.println("level not found");
        printcousins(root, node, level);

    }
    private static void printcousins(Node root, Node node, int level) {
        if(root== null) return;
        if(level==1) {
            System.out.println(root.data+"*");
            return;
        }
        System.out.println(root.data+" ");
        if (!(root.left != null && root.left == node ||
                root.right != null && root.right == node)) {
            printcousins(root.left, node, level-1);
            printcousins(root.right, node, level-1);
        }
    }

    private static int findLevel(Node root, Node node, int level, int nodeLevel) {
        if(root == null) return level;
        if(node == root) level = nodeLevel;
        else {
            level = findLevel(root.left, node, level, nodeLevel+1);
            level = findLevel(root.right, node,level,  nodeLevel + 1);
        }
        return level;
    }

}
