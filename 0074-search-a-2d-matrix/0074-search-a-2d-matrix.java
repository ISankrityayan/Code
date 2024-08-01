class Solution {

    public boolean BinarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                cStart = mid + 1;
            } else {
                cEnd = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Binary search on middle column to find potential row
        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        while (rStart < rEnd) {
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[mid][cMid] == target) {
                return true;
            } else if (matrix[mid][cMid] < target) {
                rStart = mid + 1;
            } else {
                rEnd = mid;
            }
        }

        // We now have two rows to check, rStart and rStart-1 (if rStart > 0)
        if (BinarySearch(matrix, rStart, 0, cols - 1, target)) {
            return true;
        }
        if (rStart > 0 && BinarySearch(matrix, rStart - 1, 0, cols - 1, target)) {
            return true;
        }
         if (rStart < rows - 1 && BinarySearch(matrix, rStart + 1, 0, cols - 1, target)) {
            return true;
        }

        return false;
    }
}
