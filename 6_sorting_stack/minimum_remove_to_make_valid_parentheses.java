class Solution {
    /*
    lee(t(c)o)de) -> lee(t(c)o)de

    Idea:
    * transform string to array
    * count `balance`. If balance == 0 and close => remove current
    * A)B( - invalid, AB - valid
    * A(B - AB
    * A)B((
    * A(((B

    * go in both directions
        * left -> right: open must be >= close
        * right -> left: close can be >= open.
    */
    public String minRemoveToMakeValid(String s) {
        char[] parenths = s.toCharArray();
        int open = 0; // 0
        int close = 0; // 1
        char openBr = '(';
        char closeBr = ')';

        for (int i = 0; i < parenths.length; i++) {
            char curr = parenths[i]; // (
            if (curr == openBr) {
                open++;
            } else if (curr == closeBr) {
                close++;
            }

            if (close > open) {
                parenths[i] = '#';
                close--;
            }
        }

        open = 0;
        close = 0;
        for (int i = parenths.length - 1; i >= 0; i--) {
            char curr = parenths[i];
            if (curr == openBr) {
                open++;
            } else if (curr == closeBr) {
                close++;
            }

            if (open > close) {
                parenths[i] = '#';
                open--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parenths.length; i++) {
            char curr = parenths[i];
            if (curr != '#') {
                sb.append(curr);
            }
        }

        return sb.toString();
    }
}