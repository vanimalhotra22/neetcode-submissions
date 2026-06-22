class Solution {
    public boolean isMatch(String s, String p) {
        
        return solve(0, 0, s, p);
    }

    boolean solve(int i, int j, String s, String p) {

        // Pattern finished
        if (j == p.length()) {

            return i == s.length();
        }

        // Check if current characters match
        boolean match = i < s.length() &&
                (s.charAt(i) == p.charAt(j) ||
                 p.charAt(j) == '.');

        // Next character in pattern is '*'
        if (j + 1 < p.length() &&
            p.charAt(j + 1) == '*') {

            // Option 1: Ignore x*
            // Option 2: Use x* if characters match

            return solve(i, j + 2, s, p)
                    ||
                   (match && solve(i + 1, j, s, p));
        }

        // Normal character or '.'
        if (match) {

            return solve(i + 1, j + 1, s, p);
        }

        return false;
    }
}
