class Twitter {
    private HashMap<Integer, List<int[]>> tweetsMap;
    private HashMap<Integer, Set<Integer>> followerMap;
    private int count;

    public Twitter() {
        tweetsMap = new HashMap<>();
        followerMap = new HashMap<>();
        count = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweetsMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] {tweetId, count--});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> resultFeed = new ArrayList<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        followerMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for (int followeeId : followerMap.get(userId)) {
            if (tweetsMap.containsKey(followeeId)) {
                List<int[]> tweets = tweetsMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);

                minHeap.offer(new int[] {tweet[1], tweet[0], index, followeeId});
            }
        }

        while (!minHeap.isEmpty() && resultFeed.size() < 10) {
            int[] current = minHeap.poll();

            resultFeed.add(current[1]);

            int index = current[2];
            if (index > 0) {
                int[] tweet = tweetsMap.get(current[3]).get(--index);
                minHeap.offer(new int[] {tweet[1], tweet[0], index, current[3]});
            }
        }

        return resultFeed;
    }

    public void follow(int followerId, int followeeId) {
        followerMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followerMap.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
    }
}
