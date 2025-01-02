class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                return x * myPow(x, -(n + 1)); // Handle overflow
            }
            n = -n;
        }
        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }
}
