package google.trees;

public class LCA {
  static boolean foundX;
  static boolean foundY = false;
  public static void main(String[] args) {
    /* Construct the following tree
              1
            /   \
           /     \
          2       3
           \     / \
            4   5   6
               / \
              7   8
        */

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.right = new Node(4);
    root.right.left = new Node(5);
    root.right.right = new Node(6);
    root.right.left.left = new Node(7);
    root.right.left.right = new Node(8);

    System.out.println(solution(root, root.right.left.left, root.right.right).data);
    foundY=foundX=false;
    System.out.println(solution(root, root.right.left.left, root.right.left.left).data);
    foundY=foundX=false;
    int ans = solution(root, root.right.left.left, new Node(10)).data;
    if (foundX && foundY) System.out.println(ans);
    System.out.println(solution(root, root.right.left.left, root.right.left).data);
    foundY=foundX=false;
    System.out.println(solution(root, root.left, root.right.left).data);
  }

  private static Node solution(Node root, Node x, Node y) {
    if(root==null) return null;
    if(root.data==x.data) {
      foundX = true;
      return root;
    }
    if(root.data==y.data) {
      foundY = true;
      return root;
    }
    Node left = solution(root.left, x, y);
    Node right = solution(root.right, x, y);
    if(left!=null && right!=null) {
      return root;
    }
    return left!=null?left:right;
  }
}
