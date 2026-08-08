class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] right = new int[nums.length];

        
        right[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i+1];
        }

        int leftProducts = 1;
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            result[i] = leftProducts * right[i];
            leftProducts = leftProducts * nums[i];
        }

        return result;
    }
}  
