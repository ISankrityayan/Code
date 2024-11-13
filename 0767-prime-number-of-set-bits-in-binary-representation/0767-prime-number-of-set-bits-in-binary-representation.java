class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        // Bitmask representing prime numbers up to 32 (bit positions for 2, 3, 5, 7, 11, etc., are set to 1)
        int primeMask = 0b10100010100010101100; // This binary value has bits set at prime indices (2, 3, 5, 7, etc.)

        for (int i = left; i <= right; i++) {
            int count = countSetBits(i);
            if ((primeMask & (1 << count)) != 0) { // Check if count is a prime by testing the corresponding bit in primeMask
                ans++;
            }
        }
        return ans;
    }

    // Function to count set bits using bit manipulation
    private int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1); // Check if the last bit is set
            n >>= 1; // Shift right to move to the next bit
        }
        return count;
    }
}
