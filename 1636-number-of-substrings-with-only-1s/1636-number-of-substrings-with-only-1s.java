class Solution {
    public int numSub(String s) {
        int res=0,count=0,mod=1_000_000_007;
        for(int i=0;i<s.length();i++){
            count= s.charAt(i)=='1' ? count + 1: 0;
            res=(res+count)%mod;
        }
        return res;
    }
}