class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        Stack<Double> stack = new Stack<>();
        int fleetCount = 0;

        int[][] pairs = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        for (int[] pair : pairs) {

            double time = (double)(target - pair[0]) / pair[1];

            if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() < time)) {
                stack.push(time);
            }
        }
        return stack.size();  
    }
}
