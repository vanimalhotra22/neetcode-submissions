class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            int[] freq = new int[26];
            int maxFreq = 0;

            for (int j = i; j < s.length(); j++) {

                freq[s.charAt(j) - 'A']++;

                maxFreq = Math.max(maxFreq,
                                   freq[s.charAt(j) - 'A']);

                int len = j - i + 1;

                if (len - maxFreq <= k) {
                    ans = Math.max(ans, len);
                }
            }
        }

        return ans;
    }
}
