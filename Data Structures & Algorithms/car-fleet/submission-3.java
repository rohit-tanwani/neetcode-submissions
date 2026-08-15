class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> posVsSpeed = new HashMap<Integer, Integer>();
        for(int i = 0; i < position.length; i++) {
            posVsSpeed.put(position[i], speed[i]);
        }

        Arrays.sort(position);

        double[] times = new double[position.length];
        for(int i = 0; i < position.length; i++) {
            times[i] = (double)(target - position[i]) / posVsSpeed.get(position[i]);
        }

        int currentFleetCount = 1;
        double lastFleetTime = times[times.length - 1];

        for(int i = times.length - 2; i >= 0; i--) {
            if(times[i] > lastFleetTime) {
                currentFleetCount++;
                lastFleetTime = times[i];
            }
        }

        return currentFleetCount;
    }
}
