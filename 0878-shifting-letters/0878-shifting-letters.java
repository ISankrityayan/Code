class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n=shifts.length;
        for(int i=n-2;i>=0;i--){
            shifts[i]=(shifts[i]+shifts[i+1])%26;
        }
        char[] chars=s.toCharArray();
        for(int i=0;i<n;i++){
            chars[i] = (char)((chars[i] - 'a' + shifts[i]) % 26 + 'a');
        }

                return new String(chars);

    }
}