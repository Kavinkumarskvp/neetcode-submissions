class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        backtrack(result, new boolean[n][n], n, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, boolean[][] current, int total,
        int row) {
        if (row >= total) {
            result.add(formChessboard(current));
            return;
        }

        for(int col = 0; col < total; col ++) {
        if (isValidPosition(row, col, current)) {
            current[row][col] = true;
            backtrack(result, current, total, row + 1);
            current[row][col] = false;
        }
        }
    }

    private boolean isValidPosition(int row, int col, boolean[][] table) {
        
        //vertical check
        for (int r = 0; r < row; r++) {
            if (table[r][col]) {
                return false;
            }
        }

        //diagonal left
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (table[r][c]) {
                return false;
            }
        }

        //diagonal right
        for (int r = row - 1, c = col + 1; r >= 0 && c < table.length; r--, c++) {
            if (table[r][c]) {
                return false;
            }
        }

        
        return true;
    }

    private List<String> formChessboard(boolean[][] table) {

        List<String> board = new ArrayList<>();


        for (int row = 0; row < table.length; row++) {

            StringBuilder string = new StringBuilder();
            for ( int col = 0; col < table.length; col++) {
                
                if(table[row][col])
                    string.append('Q');
                else
                    string.append('.');
            }
            board.add(string.toString());
        }
        return board;
    }
}
