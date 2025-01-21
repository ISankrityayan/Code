class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxGold=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>0){
                 maxGold = Math.max(maxGold, backtrack(grid, i, j));

                }
            }
        }
        return maxGold;

    }
    private int backtrack(int[][] grid, int i, int j){
        if(i<0 || j<0 ||  i>=grid.length || j>=grid[0].length || grid[i][j]==0 ){
            return 0;
        }

        int gold=grid[i][j];
        grid[i][j]=0;
        int left=backtrack(grid,i,j+1);
        int right=backtrack(grid,i,j-1);
        int up=backtrack(grid,i-1,j);
        int down=backtrack(grid,i+1,j);

        grid[i][j]=gold;

    return gold + Math.max(Math.max(left, right), Math.max(up, down));




    }
}