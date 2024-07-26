class Solution {
    public int specialArray(int[] nums) {
         // Sort the array
        Arrays.sort(nums);
        int n = nums.length;

        // Iterate from 0 to n to check for the special number x
        for (int x = 0; x <= n; x++) {
            // Count how many numbers are greater than or equal to x
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] >= x) {
                    count = n - i;
                    break;
                }
            }
            // If the count equals x, return x
            if (count == x) {
                return x;
            }
        }

        // If no such x is found, return -1
        return -1;
    
    }
}