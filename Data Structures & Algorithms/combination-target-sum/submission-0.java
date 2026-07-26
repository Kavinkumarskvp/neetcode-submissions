class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, new ArrayList<>(), nums, target, 0);

        return result;
    }

    private void dfs(
        List<List<Integer>> result, List<Integer> current, int[] nums, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index >= nums.length) {
            return;
        }

        current.add(nums[index]);
        dfs(result, current, nums, target - nums[index], index);
        current.removeLast();
        dfs(result, current, nums, target, index + 1);
    }
}
