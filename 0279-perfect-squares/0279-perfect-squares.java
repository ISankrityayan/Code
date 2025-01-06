class Solution {
    public int numSquares(int n) {
    // Step 1: Check if n is a perfect square
    if(isPerfectSquare(n)){
        return 1;
    }
// Step 2: Check if n can be expressed as the sum of two perfect squares
    for(int i=1;i*i<=n;i++){
        if(isPerfectSquare(n-i*i))
        return 2;
    }
// Step 3: Apply Legendre's Three Square Theorem

    while(n%4==0){
        n/=4;
    }
    if(n%8==7){
        return 4;
    }
    // Step 4: If none of the above, then the answer is 3
    return 3;

    }

    private boolean isPerfectSquare(int x) {
        int sqrt = (int) Math.sqrt(x);
        return sqrt * sqrt == x;
    }
}