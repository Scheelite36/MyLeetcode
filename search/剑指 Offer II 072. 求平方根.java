package search;

/**
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 * 
 * 正数的平方根有两个，只输出其中的正数平方根。
 * 
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 * 
 *  
 * 
 * 示例 1:
 * 
 * 输入: x = 4
 * 输出: 2
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jJ0w9p
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution072 {
    public int mySqrt(int x) {
        return binarySearch((long) x, 0, x);
    }

    public int binarySearch(long x, int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;
            if ((long) mid * mid >= x)
                r = mid;
            else
                l = mid + 1;
        }
        // 题目要求的是整数部分 但是结果可能取到的是整数部分大1的情况
        if ((long) l * l > x)
            return l - 1;
        else return l;
    }
}
