class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";  // Early return for zero cases

        char[] s1 = reverse(num1);
        char[] s2 = reverse(num2);
        int[] res = new int[s1.length + s2.length];

        // Multiply each digit
        for (int i = 0; i < s1.length; i++) {
            int carry = 0;
            int start = i;
            for (int j = 0; j < s2.length; j++) {
                int n1 = s1[i] - '0';
                int n2 = s2[j] - '0';
                int sum = (n1 * n2) + res[start] + carry;
                int base = sum % 10;
                carry = sum / 10;
                res[start++] = base;
            }
            if (carry != 0) res[start] = carry;
        }

        // Skip leading zeros
        int i = res.length - 1;
        while (i > 0 && res[i] == 0) i--;

        // Check if the result is zero
        if (i == 0 && res[0] == 0) return "0";

        // Build the result string
        String ans = "";
        while (i >= 0) {
            ans += res[i--];
        }

        return ans;
    }

    private char[] reverse(String num) {
        char[] ans = num.toCharArray();
        int start = 0, end = num.length() - 1;
        while (start < end) {
            char temp = ans[start];
            ans[start] = ans[end];
            ans[end] = temp;
            start++;
            end--;
        }
        return ans;
    }
}
