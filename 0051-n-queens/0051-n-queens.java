

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with empty spaces ('.')
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        solve(0, board, result);
        return result;
    }

    private void solve(int row, char[][] board, List<List<String>> result) {
        if (row == board.length) { // All queens placed successfully
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) { // Check if it's safe to place a queen
                board[row][col] = 'Q'; // Place the queen
                solve(row + 1, board, result); // Recursively place the next queen
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        // Check vertical column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check diagonal left
        for (int i = 1; i <= Math.min(row, col); i++) {
            if (board[row - i][col - i] == 'Q') {
                return false;
            }
        }

        // Check diagonal right
        for (int i = 1; i <= Math.min(row, board.length - col - 1); i++) {
            if (board[row - i][col + i] == 'Q') {
                return false;
            }
        }

        return true; // Safe to place the queen
    }

    private List<String> constructBoard(char[][] board) {
        List<String> config = new ArrayList<>();
        for (char[] row : board) {
            config.add(new String(row));
        }
        return config;
    }
}
