

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>(); // Return an empty list if input is null or empty
        }

        Map<Character, String> charArray = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );

        List<String> res = new ArrayList<>();
        getLetterCombinations("", digits, charArray, res);
        return res;
    }

    private void getLetterCombinations(String p, String up, Map<Character, String> charArray, List<String> res) {
        if (up.isEmpty()) {
            res.add(p);
            return;
        }
        char digit = up.charAt(0);
        String letters = charArray.get(digit);
        if (letters == null) return;

        for (int i = 0; i < letters.length(); i++) {
            getLetterCombinations(p + letters.charAt(i), up.substring(1), charArray, res);
        }
    }
}
