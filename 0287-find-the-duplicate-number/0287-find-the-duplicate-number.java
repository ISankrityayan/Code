class Solution {
    public int findDuplicate(int[] nums) {
        int start=0;
        while(start<nums.length){
            if(nums[start]!=start+1){
                int correct=nums[start]-1;
            if(nums[start]!=nums[correct] ){
                swapArray(nums,start,correct);
            }
            else{
               return nums[start];
            }

            }
            else{
                start++;
            }
            
        }

        return -1;
       
    }

      public void swapArray(int[]arr,int first,int second){
        int temp= arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}