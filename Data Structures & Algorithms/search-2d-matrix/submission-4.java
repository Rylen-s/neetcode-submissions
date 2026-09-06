class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        int row = 0; int m = -1;
        while(l <= r) {
            m = (l + r) / 2;
            if(m == matrix.length - 1 && target >= matrix[m][0] || target >= matrix[m][0] && matrix[m+1][0] > target) {
                row = m;
                break;
            }
            else if(matrix[m][0] > target) {
                r = m - 1;
            }
            else if(matrix[m][0] < target) {
                l = m + 1;
            }
        }

        System.out.println("Second");
        l = 0; r = matrix[0].length - 1;
        while(l <= r) {
            m = (l + r) / 2;
            if(matrix[row][m] == target) {
                return true;
            }
            else if(matrix[row][m] > target) {
                r = m - 1;
            }
            else if(matrix[row][m] < target) {
                l = m + 1;
            }
        }
        return false;
    }
}
