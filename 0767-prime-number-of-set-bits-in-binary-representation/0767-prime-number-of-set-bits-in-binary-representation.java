

class Solution {
    public int countPrimeSetBits(int left, int right) {
        // Precompute prime numbers up to 32, since the bit count will not exceed this
        Set<Integer> primeSet = Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);
        
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int bitCount = Integer.bitCount(i); // Directly count set bits
            
            if (primeSet.contains(bitCount)) { // Check if bit count is a prime
                ans++;
            }
        }
        
        return ans;
    }
}
