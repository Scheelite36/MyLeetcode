import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 记录每一行每个数字出现的个数
        int[][] row = new int[9][9];
        // 记录每一列每个数字出现的个数
        int[][] column = new int[9][9];
        // 记录小个9宫格数字出现的个数
        int[][][] smallBorad = new int[3][3][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c != '.') {
                    // 使得数字直接对应索引
                    int index = c - '1';
                    // 依次给行 列 小9宫格计数
                    ++row[i][index];
                    ++column[j][index];
                    ++smallBorad[i / 3][j / 3][index];
                    if (row[i][index] > 1 || column[j][index] > 1 ||
                            smallBorad[i / 3][j / 3][index] > 1)
                        return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
