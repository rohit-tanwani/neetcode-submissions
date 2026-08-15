class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int colTop = 0;
        int colBottom = matrix.length;
        int row = -1;
        int colMid = (colTop + colBottom) / 2;

        while(colBottom > colTop) {
            if(target >= matrix[colMid][0] && target <= matrix[colMid][n - 1]) {
                row = colMid;
                break;
            }
            else if(target > matrix[colMid][n - 1]) {
                colTop = colMid + 1;
            }
            else {
                colBottom = colMid;
            }
            colMid = (colTop + colBottom) / 2;
        }

        if(row == -1) {
            return false;
        }

        int left = 0;
        int right = matrix[row].length;
        int mid = (left + right) / 2;

        while(right > left) {
            if(matrix[row][mid] == target) {
                return true;
            }
            else if(matrix[row][mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }

            mid = (left + right) / 2;
        }
        return false;
    }
}
