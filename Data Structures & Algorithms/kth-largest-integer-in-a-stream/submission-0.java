class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        
        minHeap = new PriorityQueue<>();
        this.k = k;

        for (int n : nums) {
            minHeap.offer(n);
            
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        
        minHeap.offer(val);
        if(minHeap.size() > k) {
                minHeap.poll();
            }
        
        return minHeap.peek();
    }
}
