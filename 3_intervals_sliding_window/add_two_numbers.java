/*
2. Add Two Numbers
Medium
28.4K
5.5K
Companies
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]

Output: [7,0,8]
Explanation: 342 + 465 = 807.

3 4 2
4 6 5
8  0  7


Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
*/

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
     * traverse till both null
     * extract curr value or 0
     * sum both values + carry
     * % - curr value; / - to carry

     */

    // Time: O(n + m)
    // Space: O(max(n,m))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0; // 1
        // l1 = [0,9,9], l2 = [6,9]
        // 990 + 96 = 1086 [6,8,0,1]
        // 390 + 46 = 436
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = (l1 != null) ? l1.val : 0; // 3
            int l2Val = (l2 != null) ? l2.val : 0; // 0

            int totalSum = l1Val + l2Val + carry; // 3 + 1
            carry = totalSum / 10; // 0
            ListNode currNode = new ListNode(totalSum % 10);

            curr.next = currNode;
            curr = curr.next;

            l1 = (l1 != null) ? l1.next : null; // null
            l2 = (l2 != null) ? l2.next : null; // null
        }
        return dummy.next;
    }
}
