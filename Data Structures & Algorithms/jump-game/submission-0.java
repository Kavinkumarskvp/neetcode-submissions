class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int position = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            int currentJump = nums[i];

            if (currentJump >= position - i) {
                position = i;
            }
        }

        return position == 0 ? true : false;
    }
}
