class Solution {
    public int reachNumber(int target) {
        target=Math.abs(target);
      int steps=0;
      int sum=0;
      while(sum<target){
        
        steps++;
        sum+=steps;
      }

    while((sum-target)%2!=0){
        steps++;
        sum+=steps;
    }
    return steps;
        
    }
}