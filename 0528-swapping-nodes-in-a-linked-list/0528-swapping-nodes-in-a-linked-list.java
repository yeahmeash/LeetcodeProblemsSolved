/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = null, second = head, curr = head;
        int i = 1;

        while (curr != null) {
            if (i == k) first = curr;        // k-th from start
            if (i > k) second = second.next; // start moving after k
            curr = curr.next;
            i++;
        }

        // swap values
        int val = first.val;
        first.val = second.val;
        second.val = val;

        return head;
    }
}
