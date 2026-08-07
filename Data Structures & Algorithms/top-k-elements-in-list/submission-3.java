class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mapOfNumberVsFrequency = new HashMap<Integer, Integer>();
        for(Integer num: nums) {
            if(!mapOfNumberVsFrequency.containsKey(num)) {
                mapOfNumberVsFrequency.put(num, 0);
            }
            mapOfNumberVsFrequency.put(num, mapOfNumberVsFrequency.get(num) + 1);
        }

        Map<Integer, List<Integer>> mapOfFreqVsListOfInteger = new HashMap<Integer, List<Integer>>();

        for(Integer num: mapOfNumberVsFrequency.keySet()) {
            Integer freq = mapOfNumberVsFrequency.get(num);

            if(!mapOfFreqVsListOfInteger.containsKey(freq)) {
                mapOfFreqVsListOfInteger.put(freq, new ArrayList<Integer>());
            }

            mapOfFreqVsListOfInteger.get(freq).add(num);
        }

        int i = nums.length;
        int[] result = new int[k];
        int j = 0;
        while(i > 0 && j < k) {
            if(mapOfFreqVsListOfInteger.containsKey(i)) {
                List<Integer> numbers = mapOfFreqVsListOfInteger.get(i);
                for(Integer num: numbers) {
                    if(j < k) {
                        result[j++] = num;
                    }
                    else{
                        break;
                    }
                }
            }
            i--;
        }

        return result;
    }
}
