class Solution {
    public int findDays(int[]weights,int capacity){
        int days=1;
        int load=0;
        int n=weights.length;
        for(int i=0;i<n;i++){
            if(load+weights[i]>capacity){
                days++;
                load=weights[i];

            }
            else{
                load+=weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
       int low=Integer.MIN_VALUE;
       int high=0;
       for(int i=0;i<weights.length;i++){
        high+=weights[i];
        low=Math.max(low,weights[i]);
       }

       while(low<=high){
        int mid=low+(high-low)/2;
        int daysReq=findDays(weights,mid);
        if(daysReq<=days){
           high=mid-1;
        }
        else{
            low=mid+1;
        }
       }
       return  low;
    }
}