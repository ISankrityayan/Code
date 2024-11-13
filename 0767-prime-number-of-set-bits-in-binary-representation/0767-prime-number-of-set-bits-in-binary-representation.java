class Solution {
    public int countPrimeSetBits(int left, int right) {
        int primecount=0;
        for(int i=left;i<=right;i++){
            int setBitCount=Integer.bitCount(i);
            if(isPrime(setBitCount)){
                primecount++;
            }
        }
               
        return  primecount++;
    }
    public boolean isPrime(int num){
       if(num<=1)return false;
        for(int i=2; i*i<=num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }


}