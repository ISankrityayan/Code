class Solution {
    static final long MOD = 1000000007;  // Large prime number for modulo operations to prevent overflow

    // Function to compute 3^x % MOD using recursive exponentiation
    public long power(int x) {
        if (x == 0) {
            return 1;  // Base case: Any number raised to 0 is 1
        }
        long ans = power(x / 2);  // Recursive call to compute power(x/2)
        ans = (ans * ans) % MOD;  // Ensure the result remains within MOD

        if (x % 2 != 0) return (ans * 3) % MOD;  // If x is odd, multiply by 3 and take modulo
        return ans;  // Return the computed power
    }

    // Function to find the maximum nice divisors of a number based on prime factorization
    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors == 1) return 1;  // If only 1 prime factor, return 1

        long ans;
        // If primeFactors is a multiple of 3, compute 3^(n/3)
        if (primeFactors % 3 == 0) ans = power(primeFactors / 3);
        // If remainder is 1, replace one 3 with a 4 to maximize the product
        else if (primeFactors % 3 == 1) ans = (4 * power(primeFactors / 3 - 1)) % MOD;
        // If remainder is 2, multiply by 2 directly
        else ans = (2 * power(primeFactors / 3)) % MOD;

        return (int) ans;  // Convert the long result to int before returning
    }
}
