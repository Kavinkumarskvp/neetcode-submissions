class Solution {
    public int jump(int[] nums) {
        int l = 0, r = 0;
        int jumps = 0;

        while (r < nums.length - 1) {
            int farthest = r;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }

            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }
}
