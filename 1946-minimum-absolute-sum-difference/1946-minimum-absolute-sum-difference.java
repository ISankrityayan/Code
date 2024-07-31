import java.util.*;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int M = 1_000_000_007;
        int sum = 0;
        int[] diff = new int[n];
        
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff[i]) % M;
        }
        
        Arrays.sort(nums1);
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            int j = Arrays.binarySearch(nums1, nums2[i]);
            if (j < 0) {
                j = -(j + 1);  // Convert to insertion point
            }
            if (j != 0 && j != n) {
                arr[i] = Math.min(Math.abs(nums2[i] - nums1[j]), Math.abs(nums2[i] - nums1[j - 1]));
            } else if (j == 0) {
                arr[i] = Math.abs(nums2[i] - nums1[j]);
            } else {
                arr[i] = Math.abs(nums2[i] - nums1[j - 1]);
            }
        }
        
        int bestSave = 0;
        for (int i = 0; i < n; i++) {
            bestSave = Math.max(bestSave, diff[i] - arr[i]);
        }
        
        return (sum - bestSave + M) % M;
    }
}
