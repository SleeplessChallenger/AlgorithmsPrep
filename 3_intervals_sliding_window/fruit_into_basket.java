class Solution {
    /*
    * `i` is the type of the tree
    * 2 baskets with each holding 1 type
    * any size, but 2 fruits
    
    [1,2,1] -> 3
    [0,1,2,2] -> 3
    [1,2,3,2,2] -> 4
    [0,0,0,1,1,2,2,3,3,3] -> 5 (either 00011 or 22333)
    
    { 0 : 2; 1 : 4 } -> { 1 : 4; 2 : 6 }
    
    Solution:
    * use sliding window + Map
    * keep size of map == 2 and if new appears -> another logic
    * keep `longest` variable. When condition above met - `while` to decrease size
    * in map put the max index to make `left` pointer move right
    */
    
    // Time: O(n)
    // Space: O(n)
    public int totalFruit(int[] fruits) {
        int left = 0; // 0
        int right = 0; // 1
        final Map<Integer, Integer> map = new HashMap<>(); // { 1 : 1; 2 : 3 }
        int longest = Integer.MIN_VALUE; // 2
        
        while (right < fruits.length) {
            int currNum = fruits[right]; // 
            
            while (map.size() == 2 && !map.containsKey(currNum)) {
                int leftNum = fruits[left]; // 
                if (map.get(leftNum) == left) {
                    map.remove(leftNum);
                }
                left++;
            }
            
            longest = Math.max(longest, right - left + 1);
            map.put(currNum, right);
            right++;
        }
        
        return longest;
    }
}