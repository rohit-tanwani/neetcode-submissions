class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] result = new int[temperatures.length];
        Map<Integer, Integer> numberVsIndex = new HashMap<Integer, Integer>();

        for(int i = temperatures.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= temperatures[i]) {
                stack.pop();
            }

            numberVsIndex.put(temperatures[i], i);
            int value = stack.isEmpty() ? 0 : numberVsIndex.get(stack.peek()) - i;
            result[i] = value;
            stack.push(temperatures[i]);
        }

        return result;
    }
}
