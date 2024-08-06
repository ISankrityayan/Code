import java.util.Arrays;

class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean canSplit(int[] arr, int k, int maxSum) {
        int sum = 0;
        int count = 1; // Start with one subarray

        for (int num : arr) {
            sum += num;
            if (sum > maxSum) {
                count++;
                sum = num; // Start a new subarray
            }
        }

        return count <= k;
    }

   
}
