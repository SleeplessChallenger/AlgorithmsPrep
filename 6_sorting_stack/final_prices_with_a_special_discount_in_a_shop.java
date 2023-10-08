class Solution {
    /*
     * keep stack with (idx, price)
     * if stack > 0 && stack[-1] <= currVal => `currVal - stack[-1]` and put in idx of prev
     */
    public int[] finalPrices(int[] prices) {
        final ArrayDeque<Pair<Integer, Integer>> stack = new ArrayDeque<>();
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            res[i] = prices[i];
        }

        // 8 4 6 2 3
        // 4 2 4 2 3
        int idx = 0;
        while (idx < prices.length) {
            int currTemp = prices[idx];

            while (!stack.isEmpty() && stack.getLast().getValue() >= currTemp) {
                int prevIdx = stack.getLast().getKey();
                res[prevIdx] = stack.getLast().getValue() - currTemp;
                stack.removeLast();
            }

            stack.add(new Pair<>(idx, currTemp));
            idx++;
        }

        return res;
    }
}