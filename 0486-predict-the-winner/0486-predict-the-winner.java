class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Calculate Player 1's maximum score
        int player1Score = maxScore(0, n - 1, nums);

        // Calculate Player 2's score
        int player2Score = totalSum - player1Score;

        // Player 1 wins if their score is greater than or equal to Player 2's score
        return player1Score >= player2Score;
    }

    private int maxScore(int start, int end, int[] nums) {
        if (start > end) {
            return 0; // No elements left, no score to add
        }

        // If Player 1 picks `nums[start]`, Player 2 takes the optimal score from the remaining array
        int pickStart = nums[start] + Math.min(
            maxScore(start + 2, end, nums),  // Player 2 chooses optimally after Player 1 picks start
            maxScore(start + 1, end - 1, nums) // Player 2 chooses optimally after Player 1 picks end
        );

        // If Player 1 picks `nums[end]`, Player 2 takes the optimal score from the remaining array
        int pickEnd = nums[end] + Math.min(
            maxScore(start + 1, end - 1, nums), // Player 2 chooses optimally after Player 1 picks start
            maxScore(start, end - 2, nums) // Player 2 chooses optimally after Player 1 picks end
        );

        // Return the maximum score Player 1 can achieve
        return Math.max(pickStart, pickEnd);
    }
}
