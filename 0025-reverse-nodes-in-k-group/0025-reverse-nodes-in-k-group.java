class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // A dummy node with 0 as value and pointing to the head of the list
        ListNode dummyNode = new ListNode(0, head);
        ListNode predecessor = dummyNode, current = dummyNode;

        // Iterate through the list
        while (current.next != null) {
            // Check if there are k nodes to reverse
            for (int i = 0; i < k && current != null; i++) {
                current = current.next;
            }
            // If less than k nodes remain, no more reversing is needed
            if (current == null) {
                return dummyNode.next;
            }

            // Temporarily store the next segment to be addressed after reversal
            ListNode temp = current.next;
            // Detach the k nodes from the rest of the list
            current.next = null;
            // 'start' will be the new tail after the reversal
            ListNode start = predecessor.next;
            // Reverse the k nodes
            predecessor.next = reverseList(start);
            // Connect the new tail to the temp segment stored before
            start.next = temp;
            // Move the predecessor and current pointers k nodes ahead
            predecessor = start;
            current = predecessor;
        }
        return dummyNode.next;
    }

    /**
     * Helper method to reverse the linked list.
     * 
     * @param head The head of the list to be reversed.
     * @return The new head of the reversed list.
     */
    private ListNode reverseList(ListNode head) {
        ListNode previous = null, currentNode = head;

        // Traverse the list and reverse the links
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = previous;
            previous = currentNode;
            currentNode = nextNode;
        }
        // Return the new head of the reversed list
        return previous;
    }
}