class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start <= end) { // Your standard condition
            int mid = start + (end - start) / 2;

            // Check if mid is a peak
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && 
                (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }

            // Move towards the side where a peak is more likely
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                end = mid - 1;  // Move left
            } else {
                start = mid + 1; // Move right
            }
        }

        return -1; // Should never reach here
    }
}
