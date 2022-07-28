import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 
 *  
 * 
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 
 * 3
 * / \
 * 9 20
 * / \
 * 15 7
 * 返回：
 * 
 * [3,9,20,15,7]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
class Solution {
    List<Integer> res = new ArrayList<>();

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        getChild(Collections.singletonList(root));
        int[] resa = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resa[i] = res.get(i);
        }
        return resa;
    }

    public void getChild(List<TreeNode> list) {
        List<TreeNode> children = new ArrayList<>();
        if (list.isEmpty()) {
            return;
        }
        for (TreeNode node : list) {
            res.add(node.val);
            if (node.left != null) {
                children.add(node.left);
            }
            if (node.right != null) {
                children.add(node.right);
            }
        }
        getChild(children);
    }
}