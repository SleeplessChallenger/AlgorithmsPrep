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
    [3,2,0,-4] - 1
    [1,2] - 0
    [1] - -1
    [1,2,3,4] - -1
    [1,2,3] - -1

    * traverse with fast & slow pointers till they meet
    * start traversing again from start and one of the above
     */

    // Time: O(n)
    // Space: O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head; // 3
        ListNode slow = head; // 3

        while (fast != null && fast.next != null) {
            fast = fast.next.next; // -4
            slow = slow.next; // -4

            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            // second check for cases like [1]
            return null;
        }

        ListNode start = head;
        while (start != fast) {
            fast = fast.next;
            start = start.next;
        }

        return start;
    }
}