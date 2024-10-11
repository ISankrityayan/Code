class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int low = 1, high = removable.length, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (isASubsequenceAfterRemoving(s.toCharArray(), p.toCharArray(), removable, pivot)) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return low - 1;
    }

    private boolean isASubsequenceAfterRemoving(char[] s, char[] p, int[] removable, int limit) {
        for (int i = 0; i < limit; i++) {
            s[removable[i]] = 0;
        }
        int i = 0, j = 0;
        while (i < s.length && j < p.length) {
            if (s[i] == p[j]) {
                j++;
            }
            i++;
        }
        return j == p.length;
    }
}