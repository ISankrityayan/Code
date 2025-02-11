class Solution {
    static final long MOD = 1000000007;  // Declare as static final

    public long power(int x) {
        if (x == 0) {
            return 1;
        }
        long ans = power(x / 2);
        ans = (ans * ans) % MOD;  // Ensure modulo is applied properly
        if (x % 2 != 0) return (ans * 3) % MOD;
        return ans;
    }

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors == 1) return 1;
        long ans;
        if (primeFactors % 3 == 0) ans = power(primeFactors / 3);
        else if (primeFactors % 3 == 1) ans = (4 * power(primeFactors / 3 - 1)) % MOD;
        else ans = (2 * power(primeFactors / 3)) % MOD;
        return (int) ans;  // Return the computed result instead of MOD
    }
}
