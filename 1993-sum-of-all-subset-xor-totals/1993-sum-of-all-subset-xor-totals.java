class Solution {
    public int choice(int nums[],int i,int sum){
        if(i>=nums.length)
        return sum;
        return choice(nums,i+1,sum^nums[i]) + choice(nums,i+1,sum);
    }
    public int subsetXORSum(int[] nums) {
        return choice (nums,0,0);
    }
}