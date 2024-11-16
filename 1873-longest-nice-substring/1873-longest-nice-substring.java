import java.util.HashSet;

class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return ""; // Return an empty string for invalid cases
        }

        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c); // Add all characters to the set
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If both uppercase and lowercase of the character exist, continue
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) {
                continue;
            }

            // If not, split the string into two parts and recursively find the solution
            String pre = longestNiceSubstring(s.substring(0, i));
            String post = longestNiceSubstring(s.substring(i + 1));
            return (pre.length() >= post.length()) ? pre : post;
        }

        // If all characters meet the "nice" criteria, return the string itself
        return s;
    }
}
