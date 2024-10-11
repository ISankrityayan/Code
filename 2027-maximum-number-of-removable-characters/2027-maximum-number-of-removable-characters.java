class Solution {
   public int maximumRemovals(String s, String p, int[] rem) {
    int left = 0, right = rem.length;
    int[] removalOrder = new int[s.length()];
    
    // Marking positions of characters to be removed at each step
    for (int i = 0; i < rem.length; i++) {
        removalOrder[rem[i]] = i + 1;
    }
    
    // Binary search to find the maximum number of removals
    while (left < right) {
        int mid = (left + right + 1) / 2;
        if (isSubsequenceAfterRemovals(s, p, removalOrder, mid)) {
            left = mid;  // Try more removals
        } else {
            right = mid - 1;  // Fewer removals
        }
    }
    
    return left;
}

private boolean isSubsequenceAfterRemovals(String s, String p, int[] removalOrder, int maxRemovals) {
    int j = 0;  // Pointer for `p`
    
    for (int i = 0; i < s.length() && j < p.length(); i++) {
        // Check if character at `i` in `s` is not removed yet
        if (removalOrder[i] == 0 || removalOrder[i] > maxRemovals) {
            if (s.charAt(i) == p.charAt(j)) {
                j++;  // Move to the next character in `p`
            }
        }
    }
    
    return j == p.length();  // Check if `p` is a subsequence of `s`
}

}