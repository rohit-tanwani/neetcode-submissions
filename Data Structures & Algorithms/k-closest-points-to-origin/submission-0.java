class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<Point>(
            (p1, p2) -> {
                int distance1 = p1.x * p1.x + p1.y * p1.y;
                int distance2 = p2.x * p2.x + p2.y * p2.y;

                return Integer.compare(distance1, distance2);
            }
        );

        for(int i = 0; i < points.length; i++) {
            Point p = new Point(points[i][0], points[i][1]);
            pq.offer(p);    
        }

        int[][] result = new int[k][2];

        int i = 0;
        while(k-- > 0) {
            result[i][0] = pq.peek().x;
            result[i][1] = pq.poll().y;
            i++;
        }

        return result;
    }

    public class Point{
        public Integer x;
        public Integer y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return this.x + " " + this.y;
        }
    }
}
