class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>();
        int n=expression.length();
        for(int i=0;i<n;i++){
            char c=expression.charAt(i);
            if(c==',')continue;
            if(c==')'){
                List<Character>values=new ArrayList<>();
                while(st.peek()!='('){
                    values.add(st.pop());
                }
                st.pop();
                char op=st.pop();
                st.push(solveOp(op,values));
            }
            else{
                st.push(c);
            }
        }
        return st.peek()=='t';
    }

    private char solveOp(char op, List<Character>values){
        if(op=='!')
        return values.get(0)=='t' ? 'f' : 't';

        if(op=='&'){
            return values.stream().anyMatch(ch->ch=='f')?'f':'t';
        }
        if(op=='|')
        return values.stream().anyMatch(ch->ch=='t')?'t':'f';

        return 't';
    }
}