class Solution {
    public double average(int[] salary) {
        int min_sal=Integer.MAX_VALUE;
        int max_sal=Integer.MIN_VALUE;
        int sum=0;
        int n=salary.length;

        for(int s:salary){
            if(s<min_sal){
                min_sal=s;
            }
             if(s>max_sal){
                max_sal=s;
            }
            sum+=s;
        }

       sum=sum-min_sal-max_sal;
        return (double) sum / (n - 2);



    }
}