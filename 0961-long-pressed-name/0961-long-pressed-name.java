class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n1 = name.length();
        int n2 = typed.length();
        int idx1 = 0, idx2 = 0;

        while (idx1 < n1 && idx2 < n2) {
            // If characters match, increment both pointers
            if (name.charAt(idx1) == typed.charAt(idx2)) {
                idx1++;
                idx2++;
            } 
            // If characters don't match, but typed has the previous character long-pressed
            else if (idx1 > 0 && name.charAt(idx1 - 1) == typed.charAt(idx2)) {
                idx2++; // Only increment idx2 for long press
            } 
            // If neither of the above conditions is met, it's not a valid long press
            else {
                return false;
            }
        }

        // After looping, ensure all characters in `name` are checked
        if (idx1 < n1) {
            return false;
        }

        // Ensure the remaining characters in `typed` are just long presses of the last character in `name`
        while (idx2 < n2) {
            if (name.charAt(n1 - 1) != typed.charAt(idx2)) {
                return false;
            }
            idx2++;
        }

        return true;
    }
}
