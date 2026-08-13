class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for(int i = heights.length - 1; i >= -1; i--) {
            int currentHeight = i == -1 ? 0 : heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                int index = stack.pop();
                int lastMinHeight = heights[index];
                int rightBoundary = stack.isEmpty() ? heights.length : stack.peek();

                int width = rightBoundary - 1 - i;
                maxArea = Math.max(width * lastMinHeight, maxArea);
            }

            stack.push(i);
        }

        return maxArea;
    }
}