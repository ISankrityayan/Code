class Solution {
    public int uniquePathsIII(int[][] grid) {
        int startX=0,startY=0,emptyCells=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    startX=i;
                    startY=j;
                } else if(grid[i][j]==0)
                emptyCells++;
            }
        }

        return backtrack(grid,startX,startY,emptyCells+1);
    }
    private int backtrack(int[][]grid,int i,int j, int emptyCells){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==-1){
            return 0;
        }

        if(grid[i][j]==2){
            return emptyCells==0?1:0;
        }

        grid[i][j]=-1;
        int paths=0;
        paths+=backtrack(grid,i+1,j,emptyCells-1);
        paths+=backtrack(grid,i-1,j,emptyCells-1);
        paths+=backtrack(grid,i,j+1,emptyCells-1);
        paths+=backtrack(grid,i,j-1,emptyCells-1);

        //backtrack
        grid[i][j]=0;
        return paths;

    }

}