class Solution {
    public int missingNumber(int[] nums) {
        int start=0;
        while(start<nums.length){
            int correct=nums[start];
            if(nums[start]<nums.length && nums[start]!=nums[correct]){
                swapArray(nums,start,correct);
           }
           else {
               start++;
           }
            
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return i;
            }
        }

        return nums.length;
    }

    public void swapArray(int[]arr,int first,int second){
        int temp= arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}