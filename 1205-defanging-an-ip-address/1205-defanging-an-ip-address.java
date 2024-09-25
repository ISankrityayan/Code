class Solution {
    public String defangIPaddr(String address) {
        StringBuilder s=new StringBuilder();
        int len=address.length();
        char ch;
        for(int i=0;i<len;i++){
            ch=address.charAt(i);
            if(ch=='.'){
                s.append("[.]");
            }
            else{
                s.append(ch);
            }
        }

        return s.toString();
        
    }
}