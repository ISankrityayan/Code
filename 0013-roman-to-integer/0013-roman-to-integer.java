class Solution {
    public int romanToInt(String s) {
        // Create an array for storing Roman numeral values
        int[] roman = new int[91]; // ASCII value of 'M' is 77, so we take 91 for safety
        roman['I'] = 1;
        roman['V'] = 5;
        roman['X'] = 10;
        roman['L'] = 50;
        roman['C'] = 100;
        roman['D'] = 500;
        roman['M'] = 1000;

        int res = 0;

        // Traverse through the Roman numeral string
        for (int i = 0; i < s.length(); i++) {
            // If current value is less than the next value, subtract it (for cases like IV = 4)
            if (i < s.length() - 1 && roman[s.charAt(i)] < roman[s.charAt(i + 1)]) {
                res -= roman[s.charAt(i)];
            } 
            // Otherwise, just add the value
            else {
                res += roman[s.charAt(i)];
            }
        }

        return res;
    }
}
