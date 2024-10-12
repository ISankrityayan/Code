public class Solution {
    public int maximumRemovals(String s, String p, int[] rem) {
        int left = 0, right = rem.length;
        int[] removalIndex = new int[s.length()];
        Arrays.fill(removalIndex, rem.length);

        // Populate removalIndex array
        for (int i = 0; i < rem.length; i++) {
            removalIndex[rem[i]] = i;
        }

        // Binary search to find maximum `m`
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canFormSubsequence(s, p, removalIndex, mid)) {
                left = mid;  // Valid `mid`, move to higher range
            } else {
                right = mid - 1;  // Not valid, reduce the range
            }
        }
        
        return left;  // Maximum removals
    }

    // Helper function to check if `p` is a subsequence after removing `mid` characters from `s`
    private boolean canFormSubsequence(String s, String p, int[] removalIndex, int mid) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (removalIndex[i] >= mid && s.charAt(i) == p.charAt(j)) {
                j++;  // Move to next character in `p`
            }
            if (j == p.length()) {
                return true;  // Subsequence formed
            }
        }
        return false;  // Subsequence not formed
    }
}
