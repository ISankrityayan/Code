class Solution {
    public boolean isGoodArray(int[] nums) {
        int resGCD=nums[0];

        for(int i=1;i<nums.length;i++){
            resGCD=gcd(resGCD,nums[i]);
            if(resGCD==1){
                return true;
            }
        }

        return resGCD==1;
    }

    public int gcd(int a,int b) {

         if(b==0){
            return a;
         }

         return gcd(b,a%b);

        }

}