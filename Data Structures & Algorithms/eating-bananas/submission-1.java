class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int low = 1;
        int high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;

            int totalHours = 0;

            for (int pile : piles) {
                totalHours += (int) Math.ceil((double) pile / mid);
            }

            if (totalHours <= h) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}