class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }

        // Determine the sign of the result
        boolean sign = !((dividend < 0) ^ (divisor < 0)); // true for positive, false for negative

        // Convert both numbers to long and take their absolute values to avoid overflow
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long ans = 0;

        while (n >= d) {
            long cnt = 0;

            // Use the condition `n >= (d * (1L << (cnt + 1)))` correctly
            while (n >= (d * (1L << (cnt + 1)))) {
                cnt++;
            }

            ans += (1L << cnt); // Add the contribution to the result
            n -= (d * (1L << cnt)); // Subtract the contribution from n
        }

        // Handle overflow cases for 32-bit integers
        if (ans > Integer.MAX_VALUE) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        // Return the result with the correct sign
        return sign ? (int) ans : -(int) ans;
    }
}
