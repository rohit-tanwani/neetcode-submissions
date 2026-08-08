class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        
        result[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i+1];
        }

        int leftProducts = 1;
        for(int i = 0; i < nums.length; i++) {
            result[i] = leftProducts * result[i];
            leftProducts = leftProducts * nums[i];
        }

        return result;
    }
}  
