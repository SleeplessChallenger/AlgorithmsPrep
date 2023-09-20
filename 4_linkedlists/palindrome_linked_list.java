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
    [1,2,2,1]  1 -> 2 -> 2 -> 1;  null <- 2 <- 1
    [1,2]  1 -> 2;
    [1,2,3,2,1]

    * find pre-mid: fast/fast.next/fast.next.next
    * .next from pre-mid, reverse it (last node will be NULL)
    * return start of the reversed
    * iterate will second != null. If at any moment != => false
    * even will have equal and NULL, odd will stop at middle node

    */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head; // 2
        ListNode fast = head; // 2 (second one)

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newHead = reverseLinkedList(slow.next);

        while (newHead != null) {
            if (newHead.val != head.val) {
                return false;
            }

            newHead = newHead.next;
            head = head.next;
        }

        return true;
    }

    private static ListNode reverseLinkedList(ListNode node) {
        ListNode prev = null;
        ListNode next = null;

        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}