class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mapOfNumberVsFrequency = new HashMap<Integer, Integer>();
        for(Integer num: nums) {
            if(!mapOfNumberVsFrequency.containsKey(num)) {
                mapOfNumberVsFrequency.put(num, 0);
            }
            mapOfNumberVsFrequency.put(num, mapOfNumberVsFrequency.get(num) + 1);
        }

        TreeMap<Integer, List<Integer>> mapOfFreqVsNumbers = new TreeMap<Integer, List<Integer>>(Collections.reverseOrder());
        for(Integer num: mapOfNumberVsFrequency.keySet()) {
            Integer freq = mapOfNumberVsFrequency.get(num);
            if(!mapOfFreqVsNumbers.containsKey(freq)) {
                mapOfFreqVsNumbers.put(freq, new ArrayList<Integer>());
            }
            mapOfFreqVsNumbers.get(freq).add(num);
        }

        int[] result = new int[k];
        int i = 0;
        for(int freq: mapOfFreqVsNumbers.keySet()) {
            if(i < k) {
                List<Integer> numbers = mapOfFreqVsNumbers.get(freq);
                for(int num: numbers) {
                    result[i++] = num;
                }
            }
        }
        
        return result;
    }
}
