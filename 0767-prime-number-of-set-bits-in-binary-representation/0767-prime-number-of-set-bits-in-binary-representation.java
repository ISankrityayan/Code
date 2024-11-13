class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans=0;
        for(int i=left;i<=right;i++){
            int mask=1;
            int count=0;
            for(int j=0;j<32;j++){
                if((i&mask)!=0){
                    count++;

                }
                mask=mask<<1;

            }

              if(isPrime(count)){
            ans++;
        }
       
        }
         return ans;
      
    }

    private boolean isPrime(int num){
        if(num==1){
            return false;
        }
        if(num==2){
            return true;
        }
        for(int i=2;i<=num/2;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}