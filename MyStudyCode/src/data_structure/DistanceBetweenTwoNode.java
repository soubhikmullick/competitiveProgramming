package data_structure;
/* A Java Program to find distance between n1 and n2
using one traversal */
public class DistanceBetweenTwoNode
{
    // (To the moderator) in c++ solution this variable
    // are declared as pointers hence changes made to them
    // reflects in the whole program

    // Global static variable
    static int d1 = -1;
    static int d2 = -1;
    static int dist = 0;

    // A Binary Tree Node
    static class Node{
        Node left, right;
        int data;

        // constructor
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    static int findDistance(Node root, int n1, int n2){
        Node lca = findLca(root, n1, n2);
        System.out.println(lca.data);
        Node temp = lca;
        int ans = 0;
        return finderHelper(temp, n1, n2, ans);
    }

    static int finderHelper(Node root, int n1, int n2, int ans) {
        if(root == null) return 0;
        if(root.data == n1 || root.data == n2) return ans;
        else {
//            ans = Math.max(finderHelper(root.left, n1, n2, ans+1), ans);
//            ans = Math.max(finderHelper(root.right, n1, n2, ans+1), ans);
            return finderHelper(root.left, n1, n2, ans+1) + finderHelper(root.right, n1, n2, ans+1);
        }
//        return ans;
    }

    static Node findLca(Node root, int n1, int n2) {
        if(root == null) return null;
        if(root.data == n1 || root.data == n2) return root;

        Node leftNode = findLca(root.left, n1, n2);
        Node rightNode = findLca(root.right, n1, n2);
        if(leftNode != null && rightNode != null) return root;
        return (leftNode!=null)?leftNode:rightNode;
    }


    // Driver program to others.test above functions
    public static void main(String[] args) {

        // Let us create binary tree given in the above example
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println("Dist(4, 5) = "+findDistance(root, 4, 5));
        System.out.println("Dist(4, 6) = "+findDistance(root, 4, 6));
        System.out.println("Dist(3, 4) = "+findDistance(root, 3, 4));
        System.out.println("Dist(2, 4) = "+findDistance(root, 2, 4));
        System.out.println("Dist(8, 5) = " +findDistance(root, 8, 5));

    }
}
// This code is contributed by Sumit Ghosh
