class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row ++) {
            if (target >= matrix[row][0] && target <= matrix[row][cols - 1]) {
                return binarySearch(matrix[row], target);
            }
        }
        return false;
    }

    private boolean binarySearch (int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return true;
            else if (nums[mid] > target) right = mid -1;
            else left = mid + 1;
        }
        return false;
    }
}
