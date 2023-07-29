package google.recursions;

/*
Next Greater Node In Linked List
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LeetCode1019 {
    public int recur(ListNode head, ListNode currNode, int index, int[] solution) {
        if(currNode.next==null) {
            return currNode.val;
        }
        int max = Math.max(currNode.val, recur(head, currNode.next, index+1, solution));
        solution[index] = currNode.val==max?0:max;
        return max;
    }

    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp.next!=null) {
            size++;
            temp = temp.next;
        }
        int[] solution = new int[size+1];
        recur(head, head, 0, solution);
        return solution;
    }
}
