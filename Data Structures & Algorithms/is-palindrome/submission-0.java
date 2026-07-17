class Solution {
    public boolean isPalindrome(String s) {
        
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            Character lChar = s.charAt(left);
            Character rChar = s.charAt(right);

            if(!Character.isLetterOrDigit(lChar)) {
                left++;
                continue;
            }

            if(!Character.isLetterOrDigit(rChar)) {
                right--;
                continue;
            }

            if(Character.toLowerCase(lChar) != Character.toLowerCase(rChar)) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
}
