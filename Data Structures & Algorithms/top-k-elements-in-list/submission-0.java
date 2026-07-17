class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for( int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for(Map.Entry entry : map.entrySet()) {
            minHeap.offer(new int [] {(int)entry.getKey(), (int)entry.getValue()});
            if (minHeap.size() > k) minHeap.poll();
        }

        return minHeap.stream().mapToInt(a -> a[0]).toArray();
    }
}
