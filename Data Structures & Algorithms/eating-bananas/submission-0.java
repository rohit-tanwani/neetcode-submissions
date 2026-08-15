class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int sum = 0;
        for(int i = 0; i < piles.length; i++) {
            max = Math.max(piles[i], max);
            sum += piles[i];
        }

        int lowSpeed = 1;
        int highestSpeed = max;
        int averageSpeed = (lowSpeed + highestSpeed) / 2;
        int result = max;
        while(highestSpeed > lowSpeed) {
            int totalHours = 0;
            for(int i = 0; i < piles.length; i++) {
                totalHours += (int)Math.ceil((double)piles[i] / averageSpeed);
            }
            if(totalHours <= h) {
                result = Math.min(averageSpeed, result);
                highestSpeed = averageSpeed;
            }
            else {
                lowSpeed = averageSpeed + 1;
            }
            averageSpeed = (lowSpeed + highestSpeed) / 2;
        }

        return result;
    }
}
