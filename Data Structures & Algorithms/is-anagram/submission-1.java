class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            frequencyMap.put(sc, frequencyMap.getOrDefault(sc, 0) + 1);
            frequencyMap.put(tc, frequencyMap.getOrDefault(tc, 0) - 1);
        }

        return frequencyMap.values().stream().allMatch(v -> v == 0);
    }
}
