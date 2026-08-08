class Solution {
    public int maxArea(int[] heights) {
        int first = 0;
        int last = heights.length - 1;

        int maxArea = 0;
        while(first < last) {
            int min = Math.min(heights[first], heights[last]);
            int area = min * (last - first);
            if(area > maxArea) {
                maxArea = area;
            }

            if(min == heights[first]) {
                first++;
            }

            if(min == heights[last]) {
                last--;
            }
        }

        return maxArea;
    }
}
