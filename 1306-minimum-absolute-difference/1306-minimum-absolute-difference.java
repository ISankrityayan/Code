class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
 List<List<Integer>> ans = new ArrayList<>();
        int min_diff=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            min_diff=Math.min(arr[i+1]-arr[i],min_diff);
        }

        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]==min_diff){
               List<Integer>pair=new ArrayList<>();
               pair.add(arr[i]);
               pair.add(arr[i+1]);
               ans.add(pair);
            }
        }

        return ans;


    }
}