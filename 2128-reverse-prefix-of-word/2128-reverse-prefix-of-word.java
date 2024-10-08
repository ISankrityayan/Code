class Solution {
    public String reversePrefix(String word, char ch) {
        int prefixIndex = word.indexOf(ch);
        
        // If ch is not found, return the original word
        if (prefixIndex == -1) {
            return word;
        }
        
        // Reverse the prefix using StringBuilder
        StringBuilder reversedPrefix = new StringBuilder(word.substring(0, prefixIndex + 1));
        reversedPrefix.reverse();
        
        // Combine reversed prefix with the rest of the string
        return reversedPrefix.toString() + word.substring(prefixIndex + 1);
    }
}
