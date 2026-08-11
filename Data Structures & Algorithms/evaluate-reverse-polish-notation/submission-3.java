class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();

        int result = 0;
        for(String token: tokens) {
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.push(Integer.valueOf(token));
                continue;
            }

            int second = stack.pop();
            result = stack.pop();
            if(token.equals("+")) {
                result += second;
            }

            if(token.equals("-")) {
                result -= second;
            }

            if(token.equals("*")) {
                result *= second;
            }

            if(token.equals("/")) {
                result /= second;
            }

            stack.push(result);
        }

        if(!stack.isEmpty()) {
            result = stack.pop();
        }
        return result;
    }
}
