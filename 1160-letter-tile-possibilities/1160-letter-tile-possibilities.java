class Solution {
    public int numTilePossibilities(String tiles) {
        char[] tileArray=tiles.toCharArray();
        Arrays.sort(tileArray);
        boolean[] used = new boolean[tileArray.length];

        return backtrack(tileArray,used);

    }

    private int backtrack(char[]tiles,boolean[]used){
        int count=0;

        for(int i=0;i<tiles.length;i++){
            if(used[i]){
                continue;
            }
            if(i>0 && tiles[i]==tiles[i-1] && !used[i - 1]){

                continue;

            }

            used[i]=true;
            count++;
            count+=backtrack(tiles,used);
            used[i]=false;


        }
        return count;

    }
}