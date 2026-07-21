class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftBoundaries = new int[n];
        int[] rightBoundaries = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            leftBoundaries[i] = -1;

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                leftBoundaries[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i > -1; i--) {
            rightBoundaries[i] = n;

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                rightBoundaries[i] = stack.peek();
            }

            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            leftBoundaries[i] += 1;
            rightBoundaries[i] -= 1;
            int area = heights[i] * (rightBoundaries[i] - leftBoundaries[i] + 1);

            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
