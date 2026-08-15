class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        int min = Integer.MAX_VALUE;

        while(right >= left) {
            min = Math.min(min, nums[mid]);
            if(nums[mid] < nums[right]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        } 

        return min;
    }
}
