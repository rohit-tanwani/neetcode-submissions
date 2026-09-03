class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(pq.size() < k) {
                pq.offer(nums[i]);
            }
            else if(pq.size() >= k && pq.peek() <= nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return !pq.isEmpty() ? pq.peek() : -1;
    }
}
