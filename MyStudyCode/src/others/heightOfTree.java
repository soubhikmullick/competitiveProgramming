package others;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
public class heightOfTree {

    Node root;

    /* Compute the "maxDepth" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int maxDepth(Node node, int height, int maxH) {
        if (node == null) {
            maxH = Math.max(height, maxH);
            return maxH;
        } else {
            /* compute the depth of each subtree */
            return Math.max(maxDepth(node.left, height + 1, maxH),
            maxDepth(node.right, height + 1, maxH));
        }
    }

    /* Driver program to others.test above functions */
    public static void main(String[] args) {
        heightOfTree tree = new heightOfTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Height of tree is : " + tree.maxDepth(tree.root, 1, 1));
    }
}