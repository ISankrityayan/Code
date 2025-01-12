class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        ArrayList<Integer>result=new ArrayList<>();
        for(int i=0;i<expression.length();i++){
            char operand=expression.charAt(i);
            if(operand=='+' ||operand=='-'||operand=='*'){
                List<Integer>leftResults=diffWaysToCompute(expression.substring(0,i));
                List<Integer>rightResults=diffWaysToCompute(expression.substring(i+1));
                for(int x:leftResults){
                    for(int y: rightResults){
                        if(operand=='+')
                        result.add(x+y);
                        else if(operand=='-')
                        result.add(x-y);
                         else
                        result.add(x*y);
                    }
                }

            }
        }
        if(result.isEmpty()){
            result.add(Integer.parseInt(expression));
        }
        return result;
    }
}