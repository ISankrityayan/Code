class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[]res=nums.clone();
        Arrays.sort(res);
        Map<Integer,Integer>index=new HashMap<>();
        for(int i=0;i<res.length;i++){
            index.putIfAbsent(res[i],i);
        }
        for(int i=0;i<nums.length;i++){
            res[i]=index.get(nums[i]);
        }
        return res;
    }
}