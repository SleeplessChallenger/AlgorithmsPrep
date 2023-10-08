class Solution {
    /*
    * valid: open closed by same type; open closed in the correct order; open has corresponding close
    * in the end all there shoulb be 0 brackets
    * 1 <= s.length <= 10^4

    idea: put open on stack. If close - check that previous is of the same type. If stack empty - false

    */

    // Time: O(n)
    // Space: O(n)
    public boolean isValid(String s) {
        // "[]("
        final ArrayDeque<Character> stack = new ArrayDeque(); // [ ( ]
        final Map<Character, Character> map = Map.of(
                '}', '{', ']', '[', ')', '('
        );
        final Set<Character> openBrackets = Set.of('(', '{', '[');

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i); // ]

            if (openBrackets.contains(curr)) {
                stack.add(curr);
            } else {
                if (stack.isEmpty()) {
                    // has no open bracket, but curr is close
                    return false;
                }
                char prev = stack.removeLast(); // (
                if (map.get(curr) != prev) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}