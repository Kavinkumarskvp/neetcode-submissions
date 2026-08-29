class Solution {
    public int climbStairs(int n) {
        
        int previous1 = 1;
        int previous2 = 1;

        for(int i = 0; i < n - 1; i++) {

            int current = previous1 + previous2;
            previous2 = previous1;
            previous1 = current;
        }

        return previous1;
    }
}
