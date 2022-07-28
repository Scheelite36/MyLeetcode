package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * 
 *  
 * 
 * 示例 1:
 * 
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1 4
 * \
 *   2
 * 输出: 4
 * 示例 2:
 * 
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3 6
 * / \
 * 2 4
 * /
 * 1
 * 输出: 4
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    List<Integer> nodes = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        // 中序遍历完成后返回倒数第k个
        dfs(root);
        return nodes.get(nodes.size() - k);
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        nodes.add(node.val);
        dfs(node.right);
    }
}

/**
 * 先右边再左边再根节点
 */
class Solution2 {

    List<Integer> nodes = new ArrayList<>();
    int k;
    int res;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.right);
        if (--k == 0) {
            res = node.val;
            return;
        }
        dfs(node.left);
    }
}
