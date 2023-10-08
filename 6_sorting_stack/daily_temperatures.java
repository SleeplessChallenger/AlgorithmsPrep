class Solution {
    /*
    temperatures = [73,74,75,71,69,72,76,73]
    [1,1,4,2,1,1,0,0]

    temperatures = [30,40,50,60]
    [1,1,1,0]

    Idea:
    * use stack to keep prev dates
    * put (idx, temp) on the stack
    * if stack.size() > 0 and stack[-1][1] < curr => update
    */

    // Time: O(n)
    // Space: O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        final ArrayDeque<Pair<Integer, Integer>> stack = new ArrayDeque<>(); // [ (2, 75) (3, 71) (4, 69) (5, 72) ]
        int[] result = new int[temperatures.length]; // [1, 1, 0, 0, 0, 0]

        int idx = 0; // 6
        while (idx < temperatures.length) {
            int currTemp = temperatures[idx]; // 76

            while (!stack.isEmpty() && stack.getLast().getValue() < currTemp) {
                int prevIdx = stack.getLast().getKey();
                result[prevIdx] = idx - prevIdx;
                stack.removeLast();
            }

            stack.add(new Pair<>(idx, currTemp));
            idx++;
        }

        return result;
    }
}