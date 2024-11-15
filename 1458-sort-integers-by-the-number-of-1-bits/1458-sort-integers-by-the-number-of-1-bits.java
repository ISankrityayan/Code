class Solution {
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            res[i]=countBits(arr[i])*10001 + arr[i];

        }
        Arrays.sort(res);
        for(int i=0;i<n;i++){
            res[i]%=10001;
        }
        return res;
        
    }

    private int countBits(int n){
        int res=0;
        while(n!=0){
            if((n&1)==1){
                res++;
            }
            n>>=1;
        }
        return res;
    }
}