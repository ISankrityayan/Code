class Solution {
    public int firstMissingPositive(int[] nums) {
        int start=0;
        while(start<nums.length){
            int correct=nums[start]-1;
            if(nums[start]>0 && nums[start] <= nums.length && nums[start]!=nums[correct]){
                swapArray(nums,start,correct);
            }
            else{
                start++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length +1 ;
    }

     public void swapArray(int[]arr,int first,int second){
        int temp= arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}