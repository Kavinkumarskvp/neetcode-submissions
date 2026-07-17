class Solution {
    public boolean isValidSudoku(char[][] board) {
        int length = 9;

        Map<String, Set<Character>> subBoxes = new HashMap<>();
        Set<Character> rowSet = new HashSet<>();
        Map<Integer, Set<Character>> colSets = new HashMap<>();

        for (int r = 0; r < length; r++) {
            rowSet.clear();
            for (int c = 0; c < length; c++) {
                
                if (board[r][c] == '.') continue;

                int subBoxRow = r / 3;
                int subBoxCol = c / 3;

                if (!rowSet.add(board[r][c])
                    || !colSets.computeIfAbsent(c, v -> new HashSet<>()).add(board[r][c])
                    || !subBoxes.computeIfAbsent(subBoxRow + "," + subBoxCol, v -> new HashSet<>())
                        .add(board[r][c])) {
                    return false;
                }
            }
        }
        return true;
    }
}
