class Solution {
    public long getSumElements(long count, long val){
        return val * count - (count*(count+1))/2;
    }
    public int maxValue(int n, int index, int maxSum) {
        long left=1;
        long right=maxSum;
        long mid;
        int result=0;

        while(left<=right){
            mid= left + (right-left)/2;

            long left_count=Math.min((long)index, mid-1);
            long left_sum=getSumElements(left_count,mid);
            left_sum+=Math.max(0,index-mid+1);

            long right_count=Math.min((long)n-index-1,mid-1);
            long right_sum=getSumElements(right_count,mid);
            right_sum+=Math.max(0,n-index-1-mid+1);

            if(left_sum+right_sum+mid<=maxSum){
                result=(int)Math.max(result,mid);
                left=mid+1;
            }
            else{
                right=mid-1;
            }
           


        }

        return result;

        
    }
}