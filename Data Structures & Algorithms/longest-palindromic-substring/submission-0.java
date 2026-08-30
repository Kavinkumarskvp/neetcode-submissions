class Solution {
    public String longestPalindrome(String s) {
        int resultLength = 0;
        int resultIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                int length = r - l + 1;
                if (length > resultLength) {
                    resultLength = length;
                    resultIndex = l;
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                int length = r - l + 1;
                if (length > resultLength) {
                    resultLength = length;
                    resultIndex = l;
                }
                l--;
                r++;
            }
        }
        return s.substring(resultIndex, resultIndex + resultLength);
    }
}
