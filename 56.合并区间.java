import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]
 * 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 排序后比较
 */
class Solution56 {
    Comparator<int[]> cmp = new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        }
    };

    public int[][] merge(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), cmp);
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] > intervals[j][1]) {
                if (intervals[i][0] <= intervals[j][1])
                    intervals[j][1] = intervals[i][1];
                else
                    intervals[++j] = intervals[i];
            }
        }
        return Arrays.copyOf(intervals, j + 1);
    }
}