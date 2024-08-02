class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0; // to store the total sum of the current window
        int left = 0; // left pointer of the window
        int ans = 0; // to store the maximum frequency found

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right]; // add the current element to the window sum

            // Check if the current window is valid
            while ((long)nums[right] * (right - left + 1) > sum + k) {
                // If the window is not valid, shrink it from the left
                sum -= nums[left];
                left++;
            }

            // Update the maximum frequency
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
