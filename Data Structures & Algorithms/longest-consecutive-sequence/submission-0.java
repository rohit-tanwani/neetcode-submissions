class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueNumbers = new HashSet<Integer>();

        for(int num: nums) {
            uniqueNumbers.add(num);
        }

        ArrayList<Integer> sequenceStart = new ArrayList<Integer>();
        for(Integer num: uniqueNumbers) {
            if(!uniqueNumbers.contains(num - 1)) {
                sequenceStart.add(num);
            }
        }

        int longestSequence = 0;
        for(Integer num: sequenceStart) {
            int currentSequence = 0;
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
