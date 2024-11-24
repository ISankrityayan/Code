class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList();
        int digit;
        boolean div;
        int val;
        for(int i=left;i<=right;i++){
            div=true;
            val=i;
            while(val!=0){
                digit=val%10;
                val/=10;
                if(digit==0 || i%digit!=0){
                    div=false;
                    break;
                }
                
            }
            if(div){
                list.add(i);
            }
        }
        return list;
    }
}