class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        if(n==1) return nums[0];
        int[] dp=new int[n+1];
        dp[0] = 0;           // No money robbed with 0 houses
        dp[1] = nums[0]; 
        for(int i=2;i<=n;i++){
          dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }
}