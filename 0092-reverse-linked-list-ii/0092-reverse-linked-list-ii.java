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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Step 1: dummy node before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 2: move prev to node before "left"
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 3: reverse sublist from left to right
        ListNode curr = prev.next;     // first node of sublist
        ListNode next = null;
        ListNode prevSub = null;

        for (int i = 0; i <= right - left; i++) {
            next = curr.next;
            curr.next = prevSub;
            prevSub = curr;
            curr = next;
        }

        // Step 4: reconnect
        prev.next.next = curr;   // last node of reversed part connects to curr
        prev.next = prevSub;     // prev connects to new head of reversed part

        return dummy.next;
    }
}
