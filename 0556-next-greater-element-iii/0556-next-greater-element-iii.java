class Solution {
    public int nextGreaterElement(int n) {
        long m = n;
        int[] count = new int[10];
        int currRem = -1;
        int prevRem = -1;
        
        while (m > 0) {
            currRem = (int) m % 10; // Get the last digit of m
            m = m / 10;              // Remove the last digit from m
            count[currRem]++;        // Count the occurrence of this digit
            
            if (prevRem > currRem) { // Check if previous digit is greater than current
                int num = currRem + 1; // Find the next higher digit
                while (count[num] == 0) {
                    num++;
                }
                count[num]--;          // Use this digit
                m = m * 10 + num;      // Append it back to m
                
                // Append the smallest possible digits to form the smallest number
                for (int i = 0; i < 10; i++) {
                    while (count[i]-- > 0) {
                        m = m * 10 + i;
                    }
                }
                
                // Check if the result fits in a 32-bit integer
                return m > Integer.MAX_VALUE ? -1 : (int) m;
            }
            
            prevRem = currRem; // Update prevRem for the next iteration
        }
        
        return -1; // If no greater number is found
    }
}
