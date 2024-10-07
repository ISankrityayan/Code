class Solution {
    public boolean judgeCircle(String moves) {
        int UpDown=0;
        int LeftRight=0;

        for(char c:moves.toCharArray()){
            if(c=='U')
            UpDown++;

            if(c=='D')
            UpDown--;

            if(c=='R')
            LeftRight++;

            if(c=='L')
            LeftRight--;
        }
        return (LeftRight==0 && UpDown==0);
    }
}