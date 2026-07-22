class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;

            int k = 0;
            for (int p : piles) {
                k += Math.ceil((double) p / mid);
            }

            if (k <= h)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}
