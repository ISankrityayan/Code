class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list=new ArrayList<>();

        for(int i=0;i<queries.length;i++){
            String word=queries[i];
            boolean seq=isSubseq(word.toCharArray(),pattern.toCharArray());
            list.add(seq);
        }

        return list;
    }

    public boolean isSubseq(char[] s, char[]p){
        int i=0,j=0;
        while(i<s.length && j<p.length){
            if(s[i]==p[j]){
                i++;
                j++;
            }
            else if(Character.isUpperCase(s[i])){
                return false;
            }
            else
            i++;
        }
        while(i<s.length){
        if(Character.isUpperCase(s[i]))
         return false;

         i++;
        }
        //j pointer reaches the end of P string or P char[] then P is a subsequence of S

        return j == p.length;


    }
}