class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int leftMax = 0;
        int rightMax = 0;
        for(int i = 0; i < height.length; i++) {
            if(height[i] > leftMax) {
                leftMax = height[i];
            }

            if(height[height.length - 1 - i] > rightMax) {
                rightMax = height[height.length - 1 - i];
            }

            left[i] = leftMax - height[i];
            right[height.length - 1 - i] = rightMax - height[height.length - 1- i];
        }

        int totalCapacity = 0;
        for(int i = 0; i < height.length; i++) {
            totalCapacity += Math.min(right[i], left[i]);
        }
        return totalCapacity;
    }

}
