class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return queen(board, 0);
    }

    private int queen(boolean[][] board, int r) {
        if (r == board.length) {
            return 1; // Found a valid arrangement
        }

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, r, col)) {
                board[r][col] = true; // Place queen
                count += queen(board, r + 1); // Recur to next row
                board[r][col] = false; // Backtrack
            }
        }
        return count; // Return total valid solutions
    }

    private boolean isSafe(boolean[][] board, int row, int col) {
        // Check vertical column
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // Check diagonal left
        for (int i = 1; i <= Math.min(row, col); i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // Check diagonal right
        for (int i = 1; i <= Math.min(row, board.length - col - 1); i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true; // Safe to place the queen
    }
}
