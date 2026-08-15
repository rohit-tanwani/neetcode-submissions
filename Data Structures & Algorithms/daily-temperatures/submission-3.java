class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] result = new int[temperatures.length];

        for(int i = temperatures.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            int nextMaxIndex = stack.isEmpty() ? i : stack.peek();
            result[i] = nextMaxIndex - i;
            stack.push(i);
        }

        return result;
    }
}
