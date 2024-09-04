class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String>set=new HashSet<>();
        for(int[] obstacle:obstacles){
            set.add(obstacle[0] + " "+obstacle[1]);
        }

        int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int d=0,x=0,y=0,result=0;
        for(int command:commands){
            if(command==-2){
                d--;
                if(d==-1){
                    d=3;
                }
            }
            else if(command==-1){
                d++;
                if(d==4){
                    d=0;
                }
            }
            else{
                while(command-->0 && !set.contains((x+dirs[d][0])+ " " + (y+dirs[d][1]))){
                    x+=dirs[d][0];
                    y+=dirs[d][1];

                }
                 
            }
            result=Math.max(result,x*x+y*y);
        }

        return result;

    }

}