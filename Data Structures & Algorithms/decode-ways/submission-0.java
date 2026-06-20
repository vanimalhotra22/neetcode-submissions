class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();

        int next = 1;   // dp[n]
        int next2 = 1;  // dp[n+1] (dummy)

        for (int i = n - 1; i >= 0; i--) {

            int curr = 0;

            if (s.charAt(i) != '0') {

                curr = next;

                if (i < n - 1) {

                    int num = (s.charAt(i) - '0') * 10
                            + (s.charAt(i + 1) - '0');

                    if (num >= 10 && num <= 26) {

                        curr += next2;
                    }
                }
            }

            next2 = next;

            next = curr;
        }

        return next;
    }
}
