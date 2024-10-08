class Solution {
    public String reversePrefix(String word, char ch) {
        int prefix=word.indexOf(ch);
        if(prefix==-1){
            return word;
        }
        StringBuilder rev=new StringBuilder(word.substring(0,prefix+1));
        return rev.reverse().toString() + word.substring(prefix + 1);
    }
}