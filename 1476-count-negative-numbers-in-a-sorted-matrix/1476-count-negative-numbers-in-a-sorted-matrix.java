class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int row = 0;
        int col = cols - 1; // Initialize col to the last column index
        
        int count = 0;
        
        while (row < rows && col >= 0) {
            if (grid[row][col] < 0) {
                count += (rows - row); // All elements below grid[row][col] in the same column are negative
                col--; // Move left to check for more negative numbers in the current row
            } else {
                row++; // Move down to check in the next row
            }
        }
        
        return count;
    }
}
