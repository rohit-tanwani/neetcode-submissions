class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];

            while(j < k) {
                int sum = nums[j] + nums[k];
                if(sum > target) {
                    k--;
                }
                else if(sum < target) {
                    j++;
                }
                else {
                    result.add(new ArrayList<Integer>(List.of(nums[i], nums[j], nums[k])));
                    int firstNumber = nums[j];
                    int lastNumber = nums[k];
                    while(j < nums.length && firstNumber == nums[j]) {
                        j++;
                    }
                    while(k >= 0 && lastNumber == nums[k]) {
                        k--;
                    }
                }
            }
        }
        return result;
    }
}
