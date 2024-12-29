class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Start from every cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start backtracking if the first character matches
                if (board[i][j] == word.charAt(0) && backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false; // No match found
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        // Base Case: If all characters are matched
        if (index == word.length()) {
            return true;
        }

        // Boundary and character match check
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited by modifying it temporarily
        char temp = board[row][col];
        board[row][col] = '#'; // Use a non-alphabet character as a marker

        // Explore all four directions
        boolean found = backtrack(board, word, row + 1, col, index + 1) || // Down
                        backtrack(board, word, row - 1, col, index + 1) || // Up
                        backtrack(board, word, row, col + 1, index + 1) || // Right
                        backtrack(board, word, row, col - 1, index + 1);   // Left

        // Restore the original value of the cell
        board[row][col] = temp;

        return found;
    }
}
