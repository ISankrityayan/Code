class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>(); // Initialize the result list
        
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                // Check if the total number of 1s in both hour and minute equals turnedOn
                if (countBits(i) + countBits(j) == turnedOn) {
                    // Format the hour and minute as required
                    String hour = Integer.toString(i);
                    String minute = (j < 10 ? "0" : "") + Integer.toString(j);  // Pad single-digit minutes with '0'
                    result.add(hour + ":" + minute);
                }
            }
        }
        
        return result;
    }
    
    // Method to count the number of 1 bits in the binary representation of a number
    private int countBits(int n) {
        int count = 0;
        int mask = 1;
        
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        
        return count;
    }
}