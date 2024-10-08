class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String wordToFind = word;
        
        while (true) {
            int idx = sequence.indexOf(wordToFind);
            if (idx == -1) {
                return count;
            } else {
                count++;
                wordToFind += word;  // Build the next repeated version of the word
            }
        }
    }
}
