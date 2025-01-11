class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int score1=maxScore(0,n-1,0,nums);
        int score2=totalSum-score1;
        return score1>=score2;

    }

    private int maxScore(int start,int end,int turn,int[] nums){

        if(start>end){
            return 0;
        }
        if(turn==0){
            int score1=nums[start]+maxScore(start+1,end,1,nums);
            int score2=nums[end]+maxScore(start,end-1,1,nums);
            return Math.max(score1,score2);
        }
        else{
            int score1=maxScore(start+1,end,0,nums);
            int score2=maxScore(start,end-1,0,nums);
            return Math.min(score1,score2);

        }
    }
}