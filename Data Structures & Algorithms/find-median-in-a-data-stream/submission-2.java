class MedianFinder {
    private PriorityQueue<Integer> firstHalf;
    private PriorityQueue<Integer> secondHalf;

    public MedianFinder() {
        firstHalf = new PriorityQueue<>((a, b) -> b - a);
        secondHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        secondHalf.offer(num);

        if (secondHalf.size() - firstHalf.size() > 1
            || !firstHalf.isEmpty() && firstHalf.peek() > secondHalf.peek()) {
            firstHalf.offer(secondHalf.poll());
        }

        if (firstHalf.size() - secondHalf.size() > 1) {
            secondHalf.offer(firstHalf.poll());
        }
    }

    public double findMedian() {
        if (firstHalf.size() == secondHalf.size()) {
            return (double) (secondHalf.peek() + firstHalf.peek()) / 2.0;
        } else if (firstHalf.size() > secondHalf.size()) {
            return (double) firstHalf.peek();
        }
        return (double) secondHalf.peek();
    }
}
