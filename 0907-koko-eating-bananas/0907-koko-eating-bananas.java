class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int low=1;
        int high=Arrays.stream(piles).max().getAsInt();
        while(low<=high){
            int mid=(low+high)/2;
            int hours_taken=totalHours(piles,mid);
            if(hours_taken<=h){
               return high=mid-1;
            }
            else{
                return low=mid+1;
            }
        }
                    return low;


    }
    private int totalHours(int[] piles, int hourly){
        int total_hours=0;
        int n=piles.length;
        for(int i=0;i<n;i++){
           total_hours+=Math.ceil((double)piles[i]/hourly); 
        }
        return total_hours;
    }




}