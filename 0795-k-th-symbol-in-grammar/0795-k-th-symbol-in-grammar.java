class Solution {
    public int kthGrammar(int n, int k) {
        // Base case: If n == 1, the first row is "0".
        if (n == 1) {
            return 0;
        }

        // Find the length of the previous row
        int mid = (1 << (n - 1)) / 2; // 2^(n-1) / 2 = length / 2

        // If k is in the first half, it's the same as in the previous row.
        if (k <= mid) {
            return kthGrammar(n - 1, k);
        }
        // If k is in the second half, it's the inverse of the corresponding bit in the first half.
        else {
            return kthGrammar(n - 1, k - mid) ^ 1; // Flip the bit
        }
    }
}
