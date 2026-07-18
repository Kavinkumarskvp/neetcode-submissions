class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if ("+".equals(token)) {
                if (stack.size() > 1) {
                    int a = stack.pop();
                    int b = stack.pop();

                    stack.push(a + b);
                }
            } else if ("-".equals(token)) {
                if (stack.size() > 1) {
                    int a = stack.pop();
                    int b = stack.pop();

                    stack.push(b - a);
                }
            } else if ("*".equals(token)) {
                if (stack.size() > 1) {
                    int a = stack.pop();
                    int b = stack.pop();

                    stack.push(a * b);
                }
            } else if ("/".equals(token)) {
                if (stack.size() > 1) {
                    int a = stack.pop();
                    int b = stack.pop();

                    stack.push(b / a);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }
}
