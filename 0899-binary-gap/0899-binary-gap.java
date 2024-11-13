class Solution {
    public int binaryGap(int n) {
        int indexOne=-1, longestDist=0;
        for(int i=0;i<32;++i){
            if(((n>>i)&1)==1){
                if(indexOne!=-1)
                longestDist=Math.max(longestDist,i-indexOne);
                indexOne=i;
            }
        }
        return longestDist;
    }
}