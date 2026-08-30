class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }

        while(!pq.isEmpty()) {
            int firstMax = pq.poll();
            int secondMax = pq.isEmpty() ? 0 : pq.poll();

            if(secondMax == 0) {
                return firstMax;
            }

            int diff = firstMax - secondMax;
            pq.add(diff);
        }

        return -1;
    }
}
