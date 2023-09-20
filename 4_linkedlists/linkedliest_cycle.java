/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /*
    [3,2,0,-4] - true
    [1,2]

    * use 2 pointers: fast and slow
    * traverse till 2 pointers meet each other
    * if 0 nodes: false
    * in the loop check at first, then move pointers
    * if fast is null -> exit loop and false

    */

    // Time: O(n)
    // Space: O(1)
    public boolean hasCycle(ListNode head) {
        ListNode slow = head; // 2
        ListNode fast = head; // 1

        // if length = 0 => drop, if 1 node only => drop also
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) { // if checked at first - error
                return true;
            }
        }

        return false;
    }
}