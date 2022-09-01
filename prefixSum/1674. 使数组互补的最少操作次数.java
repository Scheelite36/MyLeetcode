package prefixSum;

/**
 * 给你一个长度为 偶数 n 的整数数组 nums 和一个整数 limit 。每一次操作，你可以将 nums 中的任何整数替换为 1 到 limit
 * 之间的另一个整数。
 * 
 * 如果对于所有下标 i（下标从 0 开始），nums[i] + nums[n - 1 - i] 都等于同一个数，则数组 nums 是 互补的 。例如，数组
 * [1,2,3,4] 是互补的，因为对于所有下标 i ，nums[i] + nums[n - 1 - i] = 5 。
 * 
 * 返回使数组 互补 的 最少 操作次数。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,2,4,3], limit = 4
 * 输出：1
 * 解释：经过 1 次操作，你可以将数组 nums 变成 [1,2,2,3]（加粗元素是变更的数字）：
 * nums[0] + nums[3] = 1 + 3 = 4.
 * nums[1] + nums[2] = 2 + 2 = 4.
 * nums[2] + nums[1] = 2 + 2 = 4.
 * nums[3] + nums[0] = 3 + 1 = 4.
 * 对于每个 i ，nums[i] + nums[n-1-i] = 4 ，所以 nums 是互补的。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-moves-to-make-array-complementary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 注意： 1 <= nums[i] <= limit <= 105
 */

/**
 * 算法是遍历每一组 nums[i] 和 nums[n - 1 - i]，然后：
 * 
 * 先将 [2, 2 * limit] 的范围需要的操作数 + 2；
 * 
 * 之后，将 [1 + min(A, B), limit + max(A, B)] 的范围需要的操作数 - 1（即 2 - 1 = 1，操作 1 次）；
 * 
 * 之后，将 [A + B] 位置的值再 -1（即 1 - 1 = 0，操作 0 次）。
 * 
 * 作者：liuyubobobo
 * 链接：https://leetcode.cn/problems/minimum-moves-to-make-array-complementary/solution/jie-zhe-ge-wen-ti-xue-xi-yi-xia-chai-fen-shu-zu-on/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution1674 {
    int[] diff;
    public int minMoves(int[] nums, int limit) {
        // nums[i]+nums[n-1-i]的最大取值范围是[2,2*limit]
        // 则有一个这样的数组 res[x]表示 nums[i]+nums[n-1-i] = x 时候的操作数，新建他的差分数组
        // 差分数组需要考虑到 r+1的情况所以范围为
        this.diff = new int[2 * limit + 2];
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i], b = nums[n-1-i];
            interact(2, limit*2, 2);
            interact(1+Math.min(a, b), limit+Math.max(a, b), -1);
            interact(a+b, a+b, -1);
        }
        int sum = 0, res = n;
        // a+b的最大取值范围是[2,2*limit]
        for (int i = 2; i < 2*limit; i++) {
            sum += diff[i];
            res = Math.min(res, sum);
        }
        return res;
    }
    /*
     * 差分数组计算
     */
    public void interact(int l, int r, int c){
        diff[l] += c;
        diff[r+1] -= c;
    }
}
