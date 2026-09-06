class Solution {
    public void rotate(int[][] matrix) {
       for(int i = 0; i < matrix.length / 2; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
            int temp = matrix[i][j];
            System.out.println(matrix[matrix.length-i-1][j]);
            matrix[i][j] = matrix[matrix.length-i-1][j];
            matrix[matrix.length-i-1][j] = temp;
            }
        } 
        int count = 0;
       for(int i = 0; i < matrix.length; i++) {
        for(int j = count; j < matrix[0].length; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
            }
            count++;
        } 
    }
}
