class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, new ArrayList<>(), nums, new HashSet<>());

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> current, int[] nums, Set<Integer> visited) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (current.size() > nums.length) return;

        for (int i = 0; i < nums.length; i++) {
            if (visited.add(i)) {
                current.add(nums[i]);
                dfs(result, current, nums, visited);
                current.removeLast();
                visited.remove(i);
            }
        }
    }
}
