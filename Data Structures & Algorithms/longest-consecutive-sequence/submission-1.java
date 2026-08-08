class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueNumbers = new HashSet<Integer>();

        for(int num: nums) {
            uniqueNumbers.add(num);
        }

        int longestSequence = 0;
        for(Integer num: uniqueNumbers) {
            int currentSequence = 0;
            if(uniqueNumbers.contains(num - 1)) {
                continue;
            }

            while(uniqueNumbers.contains(num)) {
                num++;
                currentSequence++;
            }

            if(longestSequence < currentSequence) {
                longestSequence = currentSequence;
            }
        }

        return longestSequence;
    }
}
