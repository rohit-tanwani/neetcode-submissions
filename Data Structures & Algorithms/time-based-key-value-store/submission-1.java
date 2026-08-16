class TimeMap {
    public Map<String, Map<Integer, String>> dataMap;
    public Map<String, List<Integer>> keyWithTimeStamp;

    public TimeMap() {
        dataMap = new HashMap<String, Map<Integer, String>>();
        keyWithTimeStamp = new HashMap<String, List<Integer>>();    
    }
    
    public void set(String key, String value, int timestamp) {
        if(!dataMap.containsKey(key)) {
            dataMap.put(key, new HashMap<Integer, String>());
            keyWithTimeStamp.put(key, new ArrayList<Integer>());
        }

        dataMap.get(key).put(timestamp, value);
        keyWithTimeStamp.get(key).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        if(!dataMap.containsKey(key)) {
            return "";
        }

        List<Integer> timeStamps = keyWithTimeStamp.get(key);

        int left = 0;
        int right = timeStamps.size() - 1;
        int mid = (left + right) / 2;
        int maxKey = 0;

        while(right >= left) {
            if(timeStamps.get(mid) == timestamp) {
                return dataMap.get(key).get(timestamp);
            }
            else if(timeStamps.get(mid) < timestamp) {
                maxKey = Math.max(maxKey, timeStamps.get(mid));
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        System.out.println("map==>" + dataMap);
        System.out.println("maxKey==>" + maxKey + ", value==>" + dataMap.get(key).get(maxKey));
        return dataMap.get(key).get(maxKey) == null ? "" : dataMap.get(key).get(maxKey);
    }
}
