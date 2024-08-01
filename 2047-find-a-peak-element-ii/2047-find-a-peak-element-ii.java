class Solution {

    public int maxElement(int[][]mat,int n,int m,int col){
        int maxValue=-1;
        int index=-1;
        for(int i=0;i<n;i++){
            if(mat[i][col]>maxValue){
                maxValue=mat[i][col];
                index=i;
            }
        }
        return index;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
         int start=0;
         int end=m-1;
         while(start<=end){
            int mid=start + (end-start)/2;
            int max_row=maxElement(mat,n,m,mid);
            int left=mid-1>=0 ? mat[max_row][mid-1]:-1;
            int right=mid+1<m ? mat[max_row][mid+1]:-1;

            if(mat[max_row][mid]>left && mat[max_row][mid]>right){
                return new int[]{max_row,mid};
            }
            else if(mat[max_row][mid]<left){
                end=mid-1;
            }
            else{
                start=mid+1;
            }

         }
         return new int[]{-1,-1};
    }
}