class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        int number = 0;
        int result = 0;
        int sign = 1; // +1 means positive, -1 means negative

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0'); // Build the current number
            } else if (c == '+') {
                result += number * sign; // Add the number to the result
                number = 0; // Reset number for the next digit
                sign = 1; // Update sign to positive for the next number
            } else if (c == '-') {
                result += number * sign;
                number = 0;
                sign = -1; // Update sign to negative for the next number
            } else if (c == '(') {
                // Push current result and sign onto the stack
                st.push(result);
                st.push(sign);
                result = 0; // Reset result for the new expression inside parentheses
                sign = 1; // Reset sign for the new expression inside parentheses
            } else if (c == ')') {
                result += number * sign; // Add the last number in the current expression
                number = 0;

                // Pop the sign and previous result from the stack
                int prevSign = st.pop();
                int prevResult = st.pop();
                
                result = prevResult + prevSign * result; // Apply the sign and add the previous result
            }
        }

        // After the loop ends, add the last number to the result
        result += number * sign;

        return result;
    }
}
