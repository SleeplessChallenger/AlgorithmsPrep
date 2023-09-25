
/*

Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

5, 6

    5
   /
  6

    6
   /
  5

[1,2,3,4,5,6,6] => 6


k < = len(nums)
1 <= k <= nums.length <= 10**5
*/

class Solution {
    // idea 1 - heap
    //
    //


    // Time: O(k + (n - k)*log k)
    // Space: O(k) k - proved k variable
    public int findKthLargest(int[] nums, int k) {
        // build min heap
        final PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        // 1 3 4    |   10 20 16

        // keep only k elements in our min heap
        for (int i = k; i < nums.length; i++) { // O(n)
            int num = nums[i];
            // [3,2,1,5,6,6,4] k = 3
            // [5,4,3,2,1] k = 3
            int min = queue.peek(); // min element
            if (min <= num) {
                queue.poll();
                queue.offer(num); // log k
            }
        }

        return queue.peek(); // O(1)
    }
}
