class Solution {
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> map = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        ); 

        List<String> o = new ArrayList<>();
        helper(map, o, digits, "");
        return o;
    }

    public void helper(Map<Character, String> map, List<String> o, String digits, String p) {
        if (digits.length() == 0) {
            o.add(p);
            return;
        }
        char d = digits.charAt(0);
        String words = map.get(d);
        digits = digits.substring(1);
        for (int i=0; i<words.length(); i++) {
            helper(map, o, digits, p + words.charAt(i));
        }
    } 
}