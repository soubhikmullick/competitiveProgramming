package google.trees;

import java.util.HashMap;
import java.util.Map;

public class DiagonalSum {
  public static void main(String[] args) {
      Node root = new Node(1);
      root.left = new Node(2);
      root.right = new Node(3);
      root.left.left = new Node(4);
      root.right.left = new Node(5);
      root.right.right = new Node(6);
      root.right.left.left = new Node(7);
      root.right.left.right = new Node(8);

      solution(root);
  }

  private static void solution(Node root) {
      if(root==null) System.out.println("0");
      HashMap<Integer, Integer> hm = new HashMap<>();
      hm = recurSolution(root, hm, 1);
      for (Map.Entry<Integer, Integer> aa : hm.entrySet()) {
      System.out.println(aa.getKey()+" "+aa.getValue());
      }
      for(Integer a : hm.keySet()) {
          System.out.println(a+" "+hm.get(a));
      }
  }

  private static HashMap recurSolution(Node root, HashMap<Integer, Integer> hm, int diagonal) {
      if(root==null) return hm;
      if(hm.containsKey(diagonal)) hm.put(diagonal,hm.get(diagonal)+root.data);
      else hm.put(diagonal, root.data);
      recurSolution(root.right, hm, diagonal);
      recurSolution(root.left, hm, diagonal+1);
      return hm;
  }
}
