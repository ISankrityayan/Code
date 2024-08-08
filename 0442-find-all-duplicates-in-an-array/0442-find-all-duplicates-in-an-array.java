class Solution {
    public List<Integer> findDuplicates(int[] nums) {
         int start=0;
        while(start< nums.length){
           int correct=nums[start]-1;
           if(nums[start]!=nums[correct]){
               swapArray(nums,start,correct);
           }
           else {
               start++;
           }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                ans.add(nums[i]);
            }
        }

        return ans;
    }

      static void swapArray(int[]arr,int first,int second){
        int temp= arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}