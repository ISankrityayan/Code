class Solution {
    public int xorOperation(int n, int start) {
        List<Integer> nums=new ArrayList<>();
        int r=0;
        for(int i=0;i<n;i++){
            int c=start+(2*i);
            nums.add(c);
        }
        for(int i=0;i<nums.size();i++){
            r^=nums.get(i);
        }
        return r;
    }
}