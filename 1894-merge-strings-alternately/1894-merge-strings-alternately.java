class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        StringBuilder res = new StringBuilder(n + m); // Pre-allocate expected size
        
        int i = 0;
        // Merge the common length portion
        while (i < n && i < m) {
            res.append(word1.charAt(i));
            res.append(word2.charAt(i));
            i++;
        }
        
        // Append the remaining part of the longer string
        if (i < n) {
            res.append(word1.substring(i));
        } else if (i < m) {
            res.append(word2.substring(i));
        }
        
        return res.toString();
    }
}
