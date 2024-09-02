class Solution {
    public int numIdenticalPairs(int[] nums) {
        int res=0;
        int countArray[]=new int[101];
        for(int num:nums)
        countArray[num]++;

        for(int count:countArray){
            count=(count*(count-1))/2;
            res+=count;
        }

        return res;

       
    }
}