class Solution {
    public int trap(int[] height) {
        if (height.length < 2)
            return 0;

        int l = 0;
        int r = height.length - 1;

        int maxLeft = height[l];
        int maxRight = height[r];

        int waterTrapped = 0;

        while (l < r) {
            if (maxLeft <= maxRight) {
                l++;
                maxLeft = Math.max(height[l], maxLeft);
                waterTrapped += maxLeft - height[l];

            } else {
                r--;
                maxRight = Math.max(height[r], maxRight);
                waterTrapped += maxRight - height[r];

            }
        }
        return waterTrapped;
    }
}
