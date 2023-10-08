public class Solution {
    /*
    * (()()) - 1
    * (() - 0
    Idea:
    * go and + 1 when (, else subtract
    * fianlly check: if balance == 0 ? 1 : 0
    */
    public int solve(String A) {
        // (()())
        int balance = 0; // 0
        // A length must be inside int range
        char open = '(';

        for (int i = 0; i < A.length(); i++) {
            char curr = A.charAt(i); // (
            if (balance < 0) {
                return 0;
            }
            if (curr == open) {
                balance++;
            } else {
                balance--;
            }
        }

        return (balance == 0) ? 1 : 0;
    }
}
