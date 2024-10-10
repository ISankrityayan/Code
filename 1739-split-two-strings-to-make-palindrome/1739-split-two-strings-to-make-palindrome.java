class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return canFormPalindrome(a, b) || canFormPalindrome(b, a);
    }

    private boolean canFormPalindrome(String a, String b) {
        int left = 0, right = a.length() - 1;
        while (left < right) {
            if (a.charAt(left) != b.charAt(right)) {
                // Check if the remaining substring can form a palindrome
                return isPalindrome(a, left, right) || isPalindrome(b, left, right);
            }
            left++;
            right--;
        }
        return true; // The strings are already palindromic
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false; // Found a mismatch
            }
            l++;
            r--;
        }
        return true; // This substring is a palindrome
    }
}
