class Solution {

    public int findMax(int[]v){
        int maxi=Integer.MIN_VALUE;
        int n=v.length;
        for(int i=0;i<n;i++){
           maxi=Math.max(maxi,v[i]);
        }
        return maxi;
    }
    public int calculateTotalHours(int[]v,int hourly){
        int totalH=0;
        int n=v.length;
        for(int i=0;i<n;i++){
            totalH+=Math.ceil((double)v[i]/(double)hourly);
        }
        return totalH;
    }
    public int minEatingSpeed(int[] piles, int h) {
         int low=1;
         int high=findMax(piles);
         while(low<=high){
            int mid=low+(high-low)/2;
            int totalH=calculateTotalHours(piles,mid);
            if(totalH<=h){
                high=mid-1;

            }
            else{
                low=mid+1;
            }
         }
         return low;
    }


}