class Solution {

    private Map<Character, char[]> map = new HashMap<>();

    private Solution () {
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();

        if (digits.length() > 0) {
        backtrack(result, new StringBuilder(), digits, 0);
        }

        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {

        if(index == digits.length()) {
            result.add(current.toString());
            return;
        }

        for (char c : map.get(digits.charAt(index))) {

            current.append(c);
            backtrack(result, current, digits, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
