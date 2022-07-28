package trees;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * 
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 
 * 例如:
 * 给定的树 A:
 * 
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * 
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * 
 * 示例 1：
 * 
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * 
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 找B根节点位置 如果其中一个null 都算没找到
        if (A == null || B == null)
            return false;
        // 假设 A 等于 B成立
        // 假设 A.left 等于B 满足一个即可
        return recus(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean recus(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null || A.val != B.val)
            return false;
        return recus(A.left, B.left) && recus(A.right, B.right);
    }
}