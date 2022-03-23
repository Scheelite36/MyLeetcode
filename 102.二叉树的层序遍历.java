import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        return getTreeNode(nodeList,res);
    }

    public List<List<Integer>> getTreeNode(List<TreeNode> treeNodeList, List<List<Integer>> res){
        if (treeNodeList.isEmpty()){
            return res;
        }
        List<Integer> vals = new ArrayList<>();
        List<TreeNode> childNodes = new ArrayList<>();
        for(TreeNode node:treeNodeList){
            if(node==null) {
                continue;
            }
            vals.add(node.val);
            if(node.left != null){
                childNodes.add(node.left);
            }
            if(node.right != null){
                childNodes.add(node.right);
            }
        }
        res.add(vals);
        return getTreeNode(childNodes, res);
    }
}
// @lc code=end

