class Solution {
    public int[] findErrorNums(int[] nums) {
         int start=0;
         while(start<nums.length){
            int correct=nums[start]-1;
            if(nums[start]!=nums[correct]){
                swapArray(nums,start,correct);
            }
            else{
                start++;
            }
         }

         for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return new int[]{nums[i],i+1};
            }
         }

         return new int[]{-1,-1};
    }

    static void swapArray(int[]arr,int first,int second){
        int temp= arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}