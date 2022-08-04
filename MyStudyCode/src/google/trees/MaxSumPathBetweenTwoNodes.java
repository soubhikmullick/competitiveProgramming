package google.trees;

import java.util.concurrent.atomic.AtomicInteger;

class Node
{
  int data;
  Node left, right;

  Node(int data)
  {
    this.data = data;
    this.left = this.right = null;
  }
}
public class MaxSumPathBetweenTwoNodes {
  public static void main(String[] args) {
    /* Construct the following tree
                1
              /   \
             /     \
            2      10
           / \    /  \
         -1  -4  -5   -6
             /   / \
            3   7   4
                 \
                 -2
        */

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(10);
    root.left.left = new Node(-1);
    root.left.right = new Node(-4);
    root.right.left = new Node(-5);
    root.right.right = new Node(-6);
    root.left.right.left = new Node(4);
    root.right.left.left = new Node(7);
    root.right.left.right = new Node(4);
    root.right.left.left.right = new Node(-2);

    System.out.println("The maximum path sum is " + findMaxPathSum(root));
  }

//  private static int findMaxPathSum(Node root) {
//    if(root == null) return 0;
//    AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);
//    recurMaxPath(root, result);
//    return result.get();
//  }
//
//  private static int recurMaxPath(Node root, AtomicInteger result) {
//    if(root==null) return 0;
//    int left = recurMaxPath(root.left, result);
//    int right = recurMaxPath(root.right, result);
//    int max = result.get();
//    max = Math.max(root.data, max);
//    max = Math.max(root.data+left, max);
//    max = Math.max(root.data+right, max);
//    max = Math.max(root.data+left+right, max);
//    result.set(max);
//    return Math.max(root.data, root.data+Math.max(left,right));
//  }

  private static int findMaxPathSum(Node root) {
    if(root == null) return 0;
    return recurMaxPath(root);
  }
  static int max = Integer.MIN_VALUE;

  private static int recurMaxPath(Node root) {
    if(root==null) return 0;
    int left = Math.max(recurMaxPath(root.left),0);
    int right = Math.max(recurMaxPath(root.right),0);
    max = Math.max(max, root.data + left + right);
    return root.data + Math.max(left, right);
  }
}
