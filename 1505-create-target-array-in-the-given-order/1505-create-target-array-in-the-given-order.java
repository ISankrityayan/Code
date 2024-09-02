class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer>lst=new ArrayList<>();
        for(int i=0;i<index.length;i++){
            lst.add(index[i],nums[i]);
        }
        int[]res=new int[nums.length];
        for(int i=0;i<lst.size();i++){
            res[i]=lst.get(i);
        }

        return res;
        
    }
}