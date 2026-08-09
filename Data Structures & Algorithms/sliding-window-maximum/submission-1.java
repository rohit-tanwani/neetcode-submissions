class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        int windowStart = 0;
        int windowEnd = k;
        int index = 0;

        //isko deque se bhi kiya jaa sakta hai baadme kabhi try krna

        TreeMap<Integer, Set<Integer>> mapOfNumberVsIndex = new TreeMap<Integer, Set<Integer>>();
        for(int i = windowStart; i < windowEnd; i++) {
            if(!mapOfNumberVsIndex.containsKey(nums[i])) {
                mapOfNumberVsIndex.put(nums[i], new HashSet<Integer>());
            } 
            mapOfNumberVsIndex.get(nums[i]).add(i);
        }

        result[index] = mapOfNumberVsIndex.lastKey();
        while(windowEnd < nums.length) {

            int startKey = nums[windowStart];
            Set<Integer> indices = mapOfNumberVsIndex.get(startKey);
            if(indices.size() == 1) {
                mapOfNumberVsIndex.remove(startKey);
            }
            else {
                indices.remove(windowStart);
            }
            windowStart++;

            int endKey = nums[windowEnd];
            if(!mapOfNumberVsIndex.containsKey(endKey)) {
                mapOfNumberVsIndex.put(endKey, new HashSet<Integer>());
            }
            mapOfNumberVsIndex.get(endKey).add(windowEnd);
            windowEnd++;
            result[++index] = mapOfNumberVsIndex.lastKey();
        }
        return result;
    }
}
