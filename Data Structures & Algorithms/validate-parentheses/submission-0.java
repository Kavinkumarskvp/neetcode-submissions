class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> table = new HashMap<>();
        table.put('[', ']');
        table.put('{', '}');
        table.put('(', ')');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (table.containsKey(c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && table.get(stack.peek()) == c) {
                    stack.pop();
                } else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
