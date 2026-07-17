class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int product = 1;
        int[] prefixArray = new int[length];

        for (int i = 0; i < length; i++) {
            prefixArray[i] = product;
            product *= nums[i];
        }

        product = 1;
        for (int i = length - 1; i >= 0; i--) {
            
            int temp = nums[i];
            nums[i] = product * prefixArray[i];
            product *= temp;
        }
        return nums;
    }
}
