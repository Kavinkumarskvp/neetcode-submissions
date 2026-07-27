class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word, 0, new HashSet<>(), i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(
        char[][] board, String word, int index, Set<String> visited, int row, int col) {
        if (word.length() == index) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }

        if (word.charAt(index) != board[row][col] || visited.contains(row + "," + col)) {
            return false;
        }

        visited.add(row + "," + col);
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean result = false;

        for (int[] dir : dirs) {
            result |= backtrack(board, word, index + 1, visited, row + dir[0], col + dir[1]);
        }
        visited.remove(row + "," + col);
        return result;
    }
}
