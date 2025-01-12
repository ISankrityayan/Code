class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(k,n,1,new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int k, int n,int start,List<Integer>currentCombination, List<List<Integer>>res){
      
            if(currentCombination.size() == k && n==0){
                res.add(new ArrayList<>(currentCombination));
                return;
            }
            if(currentCombination.size() > k || n < 0){
                return;
            }
            for(int i=start;i<=9;i++){
            currentCombination.add(i);
            backtrack(k,n-i,i+1,currentCombination,res);
            currentCombination.remove( currentCombination.size()-1);

            }
        
    }
}