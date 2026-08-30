class Solution {
    public boolean isHappy(int n) {
        if(n == 1) {
            return true;
        }
        HashSet<Long> squares = new HashSet<Long>();
        long squareSum = squareSum(n);
        while(!squares.contains(squareSum)) {
            if(squareSum == 1) {
                return true;
            }
            squares.add(squareSum);
            squareSum = squareSum(squareSum);
        }
        return false;
    }

    private long squareSum(long n) {
        long sum = 0;
        while(n != 0) {
            long rem = n % 10;
            sum += ((long)rem * rem);
            n /= 10;
        }
        return sum;
    }
}
