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
    /*
    [1,2,3,4,5] -> [5,4,3,2,1]

    prev = None
    curr = head
    next = None

    * traverse curr till None
    * on each iteration 1. save next node 2. flip .next of the curr 3. update prev to curr 4. update curr to the saved next

    */

    // Time: O(n)
    // Space: O(1)
    public ListNode reverseList(ListNode head) {
        ListNode curr = head; // 1
        ListNode prev = null; // null
        ListNode next = null; // 2

        while (curr != null) {
            next = curr.next; // save next node
            curr.next = prev; // flip itself
            prev = curr;
            curr = next;
        }

        return prev;
    }
}