class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), 0, nums);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int start, int[] nums) {
        
        result.add(new ArrayList<>(current));

        for(int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(result, current, i + 1, nums);
            current.removeLast();
        }
    }
}
