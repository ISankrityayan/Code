class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(result,new ArrayList<>(),nums,0);
        return result;
    }

    private void backtrack(List<List<Integer>>result,List<Integer>currentSub, int[]nums,int start){
        result.add(new ArrayList<>(currentSub));
        for(int i=start;i<nums.length;i++){
            currentSub.add(nums[i]);
            backtrack(result,currentSub,nums,i+1);
            currentSub.remove(currentSub.size()-1);
        }
    }
}