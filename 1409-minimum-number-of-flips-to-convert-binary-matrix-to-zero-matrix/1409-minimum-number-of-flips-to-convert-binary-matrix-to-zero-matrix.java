class Solution {
    int n,m;
    public int minFlips(int[][] mat) {
        n=mat.length;
        m=mat[0].length;
        int ans=sol(mat,0,0,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int sol(int[][]mat,int i,int j,int c){
        if(j==m){
            j=0;
            i++;
        }
        if(i==n){
            return isValid(mat)?c:Integer.MAX_VALUE;
        }
    // Choice 1: Do not flip the current cell and move to the next cell
        int x=sol(mat,i,j+1,c);
    // Choice 2: Flip the current cell and move to the next cell
        flip(mat,i,j); //flip
        int y=sol(mat,i,j+1,c+1); //count the flip
        flip(mat,i,j); //undo the flip (backtracking)
        return Math.min(x,y);
    }

    public boolean isValid(int[][]mat){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1)
                return false;
            }
        }
        return true;
    }

    public void flip(int[][] mat, int i, int j){
         // Flip the current cell (0 -> 1 or 1 -> 0)
        mat[i][j] ^= 1;

        // Flip the top neighbor if it exists
        if (i > 0) mat[i - 1][j] ^= 1;

        // Flip the bottom neighbor if it exists
        if (i < n - 1) mat[i + 1][j] ^= 1;

        // Flip the left neighbor if it exists
        if (j > 0) mat[i][j - 1] ^= 1;

        // Flip the right neighbor if it exists
        if (j < m - 1) mat[i][j + 1] ^= 1;
    }
}