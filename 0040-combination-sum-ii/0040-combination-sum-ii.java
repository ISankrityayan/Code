class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         // To store the result
        List<List<Integer>> result = new ArrayList<>();
        // Sort the candidates to handle duplicates
        Arrays.sort(candidates);
        // Start the backtracking process
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
        
    }
    private void backtrack(int[] candidates, int target,int start,List<Integer>currentCombination, List<List<Integer>>res){
        if(target==0){
            res.add(new ArrayList<>(currentCombination));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            currentCombination.add(candidates[i]);
            backtrack(candidates,target-candidates[i],i+1,currentCombination, res);
            // Backtrack by removing the last number added
        currentCombination.remove(currentCombination.size() - 1);

        }
    }
}