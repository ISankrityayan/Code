class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>result=new ArrayList<>();
        backtrack(candidates,target,new ArrayList<>(),result,0);
        return result;
    }

    private void backtrack(int[]candidates,int target,List<Integer>combination,List<List<Integer>>res,int start){
       if(target==0){
        res.add(new ArrayList<>(combination));
        return;
       }
        if(target<0)
        return;

        for(int i=start;i<candidates.length;i++){
            combination.add(candidates[i]);
            backtrack(candidates,target-candidates[i],combination,res,i);
            combination.remove(combination.size()-1);
        }
    }
}