class Solution {
    public boolean checkIfExist(int[] arr) {
        int n=arr.length;
       Map<Double,Integer> mp= new HashMap<>();
       for(int i=0;i<n;i++){
        if(mp.containsKey((double)arr[i]*2)|| mp.containsKey((double)arr[i]/2)){
            return true;
        }
        mp.put((double)arr[i],1);
       }
       return false;
        

        
    }
}