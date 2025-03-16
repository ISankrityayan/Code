class Solution {
    public int findPeakElement(int[] nums) {
        int start=0,end=nums.length-1;

        while(start<=end){
            int mid=start + (end-start)/2;
            //left boundary 
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length -1 || nums[mid]>nums[mid+1]) ){
                return mid;
            }

            if(mid>0 && nums[mid-1]>nums[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
            
        }
        return -1;
    }
}