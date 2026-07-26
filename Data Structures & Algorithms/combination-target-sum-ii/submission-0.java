class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(result, new ArrayList<>(), 0, candidates, target);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> current, int start, int[] candidates,
        int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            current.add(candidates[i]);
            dfs(result, current, i + 1, candidates, target - candidates[i]);
            current.removeLast();
        }
    }
}
