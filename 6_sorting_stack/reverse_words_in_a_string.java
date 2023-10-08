class Solution {
    /*
    the sky is  blue


    * iterate from the end of the string
        * if curr == " " -> iterate till != " "
        * put in array [i + 1, j] (+1 because we have made additional step)
        * j = i
    *
    */

    // Time: O(n)
    // Space: O(n)
    public String reverseWords(String s) {
        // corner: if empty string only " " or "  "
        // corner: " h " if at the end " " => j won't move
        int i = s.length() - 1; // 14; 10
        int j = s.length(); // 14;
        final StringBuilder sb = new StringBuilder();

        while (i >= 0) {
            boolean flag = false;
            while(i >= 0 && !Character.isLetterOrDigit(s.charAt(i))) { // while " "
                i--;
                j--;
            }

            while(i >= 0 && Character.isLetterOrDigit(s.charAt(i))) { // while != " "
                i--;
                flag = true;
            }

            if (flag) {
                sb.append(s.substring(i + 1, j)); // j exclusive
                sb.append(" "); // at the end it also get included
            }

            j = i;
            i--;
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}