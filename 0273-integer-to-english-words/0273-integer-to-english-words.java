class Solution {
    // Arrays to store word representations of numbers
    String[] ones = {
        "", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine",
        " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen",
        " Seventeen", " Eighteen", " Nineteen"
    };
    
    String[] tens = {
        "", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"
    };
    
    String[] thousands = {"", " Thousand", " Million", " Billion"}; // Powers of 1000
    
    // Recursive helper function to convert numbers to words
    public String helper(int n) {
        // Case 1: If the number is less than 20, return the corresponding word from the "ones" array
        if (n < 20) 
            return ones[n];
        
        // Case 2: If the number is less than 100, process the tens place and recursively process the ones place
        if (n < 100) 
            return tens[n / 10] + helper(n % 10); // Example: 42 → " Forty" + " Two"
        
        // Case 3: If the number is less than 1000, process the hundreds place and recursively process the remainder
        if (n < 1000) 
            return helper(n / 100) + " Hundred" + helper(n % 100); // Example: 345 → " Three Hundred" + " Forty Five"
        
        // Case 4: Process numbers greater than or equal to 1000 (Thousand, Million, Billion)
        for (int i = 3; i >= 0; i--) { // Iterate over the "thousands" array
            if (n >= Math.pow(1000, i)) { // Check if the number is at least 1000^i (1000, 1M, 1B)
                return helper((int)(n / Math.pow(1000, i))) + thousands[i] + helper((int)(n % Math.pow(1000, i)));
                // Example: 1,234,567 → "One Million" + "Two Hundred Thirty Four Thousand" + "Five Hundred Sixty Seven"
            }
        }
        return ""; // This line should never be reached
    }

    // Main function that converts an integer to words
    public String numberToWords(int num) {
        // Edge case: If the number is zero, return "Zero"
        if (num == 0) 
            return "Zero";
        
        // Call the helper function and remove the leading space using substring(1)
        return helper(num).substring(1);
    }
}
