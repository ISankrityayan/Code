class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        char[] chars = s.toCharArray();
        
        // Calculate the cumulative shifts from right to left in one go
        int cumulativeShift = 0;
        for (int i = n - 1; i >= 0; i--) {
            cumulativeShift = (cumulativeShift + shifts[i]) % 26;  // Avoid overflow with mod 26
            chars[i] = (char)((chars[i] - 'a' + cumulativeShift) % 26 + 'a');  // Shift characters
        }
        
        return new String(chars);  // Convert char array back to string
    }
}
