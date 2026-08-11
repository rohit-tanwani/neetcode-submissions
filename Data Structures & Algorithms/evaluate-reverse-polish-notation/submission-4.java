class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for(String token: tokens) {
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.push(Integer.valueOf(token));
                continue;
            }

            int second = stack.pop();
            int first = stack.pop();
            if(token.equals("+")) {
                first += second;
            }

            if(token.equals("-")) {
                first -= second;
            }

            if(token.equals("*")) {
                first *= second;
            }

            if(token.equals("/")) {
                first /= second;
            }

            stack.push(first);
        }

        int result = stack.pop();
        return result;
    }
}
