class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];

        for (int n : nums) {
            if (sum < 0) {
                sum = 0;
            }
            sum += n;
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
