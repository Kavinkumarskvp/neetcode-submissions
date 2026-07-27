class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), s, 0);

        return result;
    }

    private void backtrack(
        List<List<String>> result, List<String> current, String inputString, int start) {
        
        
        if (start >= inputString.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < inputString.length(); i++) {
            if (isPalindrome(inputString, start, i)) {
                current.add(inputString.substring(start, i + 1));
                backtrack(result, current, inputString, i + 1);
                current.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
