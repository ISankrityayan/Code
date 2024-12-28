class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return count(nums,target,0,0);
    }

    private int count(int[] nums, int target,int index,int sum){
        if(index==nums.length){
            return sum==target?1:0;
        }

        int plusCount=count(nums,target,index+1,sum+nums[index]);
        int minusCount=count(nums,target,index+1,sum-nums[index]);
        return plusCount+minusCount;

    }
}