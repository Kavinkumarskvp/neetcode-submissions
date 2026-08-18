class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] count = new int[26];

        for (char task : tasks) {
            count[task - 'A']++;
        }

        Arrays.sort(count);

        int maxFrequency = count[25];
        int idle = (maxFrequency - 1) * n;

        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(count[i], maxFrequency - 1);
        }

        return Math.max(0, idle) + tasks.length;
    }
}
