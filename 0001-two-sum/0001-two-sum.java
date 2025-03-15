class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[]ans=new int[2];
        ans[0]=ans[1]=-1;
       HashMap<Integer,Integer>mp=new HashMap<>();
       for(int i=0;i<nums.length;i++){
        int num=nums[i];
        int moreNeeded=target-num; 
        if(mp.containsKey(moreNeeded)){
            ans[0]=mp.get(moreNeeded);
            ans[1]=i;
            return ans;

        }
        mp.put(nums[i],i);
       }

       return ans;
        
    }
}