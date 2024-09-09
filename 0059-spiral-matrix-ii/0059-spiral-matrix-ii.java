class Solution {
    public int[][] generateMatrix(int n) {
        int r1 = 0, r2 = n - 1;
        int c1 = 0, c2 = n - 1;

        int[][] arr = new int[n][n];
        int val = 1;

        // Main loop to fill the matrix
        while (r1 <= r2 && c1 <= c2) {
            // Left to right (top row)
            for (int i = c1; i <= c2; i++) {
                arr[r1][i] = val++;
            }
            // Move down (right column)
            for (int i = r1 + 1; i <= r2; i++) {
                arr[i][c2] = val++;
            }
            // Check if there is a need to move right to left and up
            if (r1 < r2 && c1 < c2) {
                // Right to left (bottom row)
                for (int i = c2 - 1; i > c1; i--) {
                    arr[r2][i] = val++;
                }
                // Move up (left column)
                for (int i = r2; i > r1; i--) {
                    arr[i][c1] = val++;
                }
            }

            // Shrink boundaries after completing a full spiral
            r1++;
            r2--;
            c1++;
            c2--;
        }

        return arr;
    }
}
