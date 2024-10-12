class Solution {
   public int maximumRemovals(String s, String p, int[] rem) {
    int left = 0, right = rem.length;
    int[] removalOrder = new int[s.length()];
    
    // Fill the removalOrder array with rem.length initially, meaning no removals
    Arrays.fill(removalOrder, rem.length);
    
    // Populate the removalOrder array where each rem[i] stores the removal index
    for (int i = 0; i < rem.length; i++) {
        removalOrder[rem[i]] = i;
    }
    
    // Binary search to find the maximum `m` removals
    int maxM = 0;
    while (left < right) {
        int mid = (left + right + 1) / 2;
        if (isSubsequenceAfterRemovals(s, p, removalOrder, mid)) {
            left = mid;  // Move towards higher m if valid
            maxM = mid;  // Update the maxM value
        } else {
            right = mid - 1;  // Try smaller m values
        }
    }
    
    return maxM;  // Return the maxM (maximum `m` removals)
}

// Helper method to check if `p` is still a subsequence of `s` after `maxRemovals`
private boolean isSubsequenceAfterRemovals(String s, String p, int[] removalOrder, int maxRemovals) {
    int j = 0;  // Pointer for `p`
    
    // Traverse `s` and check if characters of `p` can still be matched
    for (int i = 0; i < s.length() && j < p.length(); i++) {
        // Check if the character at `i` is not removed or was removed after `maxRemovals`
        if (removalOrder[i] >= maxRemovals && s.charAt(i) == p.charAt(j)) {
            j++;  // Move to the next character in `p`
        }
    }
    
    return j == p.length();  // True if all characters of `p` are matched
}

}