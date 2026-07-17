class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            int[] chars = new int[26];
            for (char c : s.toCharArray()) chars[c - 'a']++;
            
            StringBuilder key = new StringBuilder();
            for (int i : chars) key.append(i).append('#');

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
