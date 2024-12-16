class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;

        // Find an empty cell ('.') in the Sudoku board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if (!emptyLeft) {
                break;
            }
        }

        // Base case: If no empty cell is found, the Sudoku is solved
        if (emptyLeft) {
            return true;
        }

        // Try placing digits 1-9 in the empty cell
        for (int number = 1; number <= 9; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = (char) (number + '0'); // Convert int to char
                if (solve(board)) {
                    return true; // If placing this number solves the puzzle
                } else {
                    board[row][col] = '.'; // Backtrack
                }
            }
        }

        return false; // No valid number found for this position
    }

    private boolean isSafe(char[][] board, int row, int col, int num) {
        char charNum = (char) (num + '0'); // Convert int to char for comparison
        int boxSize = 3;

        // Check the row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == charNum) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == charNum) {
                return false;
            }
        }

        // Check the 3x3 subgrid
        int rowStart = row - row % boxSize;
        int colStart = col - col % boxSize;
        for (int i = rowStart; i < rowStart + boxSize; i++) {
            for (int j = colStart; j < colStart + boxSize; j++) {
                if (board[i][j] == charNum) {
                    return false;
                }
            }
        }

        return true; // Safe to place the number
    }
}
