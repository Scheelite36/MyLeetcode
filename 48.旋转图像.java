
/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i=0;i<(len+1)/2;++i){
            for(int j=0;j<len/2;++j){
                int m = len-1-i;
                int n = len-1-j;
                int temp = matrix[i][j];
                matrix[i][j]=matrix[n][i];
                matrix[n][i] = matrix[m][n];
                matrix[m][n] = matrix[j][m];
                matrix[j][m] = temp;
            }
        }
    }
}
// @lc code=end

