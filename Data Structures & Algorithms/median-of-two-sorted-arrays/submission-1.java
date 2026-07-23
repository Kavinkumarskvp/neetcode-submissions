class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;

        if (A.length > B.length) {
            A = nums2;
            B = nums1;
        }

        int n = A.length;
        int m = B.length;
        int total = n + m;
        int half = (total + 1) / 2;

        int l = 0, r = n;
        while (l <= r) {

            int  i = l + (r - l) / 2;
            int j = half - i;

            int leftA = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int rightA = i < n ? A[i] : Integer.MAX_VALUE;
            int leftB = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int rightB = j < m ? B[j] : Integer.MAX_VALUE;

            if (leftA <= rightB  && leftB <= rightA) {

                if (total % 2 != 0) {
                    return Math.max(leftA, leftB);
                }

                return (Math.max(leftA, leftB) + Math.min (rightA, rightB)) / 2.0;
            }
            else if (leftA > rightB) {
                r = i - 1;
            }
            else {
                l = i + 1;
            }
        }
        
        return -1;
    }
}
