class Solution {
    public int maximumWealth(int[][] accounts) {

        int ans=Integer.MIN_VALUE;

        for(int[] ints:accounts){
            int rowsum=0;
            //when you start a new col take sum for that row
            for(int anInt:ints){
                rowsum+=anInt;
                

            }
            if(rowsum>ans){
                ans=rowsum;
            }

        }

        return ans;
        
    }
}