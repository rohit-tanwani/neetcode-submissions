class KthLargest {

    PriorityQueue<Integer> pq;
    int maxSize;

    public KthLargest(int k, int[] nums) {
        this.maxSize = k;
        pq = new PriorityQueue<Integer>();

        for(int i = 0; i < nums.length; i++) {
            this.add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(pq.size() < this.maxSize) {
            pq.offer(val);
        }
        else if(pq.size() >= this.maxSize && pq.peek() <= val) {
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}
