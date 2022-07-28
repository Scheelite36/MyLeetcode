import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 * 返回其层次遍历结果：
 * 
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/** 
 * 解法1： 递归 读取子节点 并保存当前节点
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        boolean order = true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        getChild(queue, order);
        return res;
    }

    public void getChild(Deque<TreeNode> nodes, boolean order){
        if (nodes.isEmpty()){
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        for(TreeNode node:nodes){
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right !=null){
                queue.offer(node.right);
            }
        }
        List<Integer> list = new ArrayList<>();
        int n = nodes.size();
        for (int i=0;i<n;i++){
            if (order){
                TreeNode node = nodes.poll();
                list.add(node.val);
            }else{
                TreeNode node =  nodes.pollLast();
                list.add(node.val);
            }
        }
        res.add(list);
        getChild(queue, !order);
    }
}

/**
 * 解法2 直接使用队列循环添加 遍历
 */

class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Boolean ordered = true;
        while(!q.isEmpty()) {
            int size = q.size();
            Integer[] layer = new Integer[size];
            for (int i=0; i<size; i++) {
                TreeNode cur = q.poll();
                if (ordered) {
                    layer[i] = cur.val;
                } else {
                    layer[size-1-i] = cur.val;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            ordered = !ordered;
            res.add(Arrays.asList(layer));
        }
        return res;
    }
}