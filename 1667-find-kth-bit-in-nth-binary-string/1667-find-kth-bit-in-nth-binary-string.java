class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        int length = (1 << n) - 1; // (2^n) - 1
        int mid = (int) Math.ceil((double) length / 2); // Ceiling for length / 2

        if (k < mid) {
            return findKthBit(n - 1, k);
        }
        if (k == mid) {
            return '1';
        } else {
            char ch = findKthBit(n - 1, length - (k - 1));
            return (ch == '0') ? '1' : '0';
        }
    }
}
