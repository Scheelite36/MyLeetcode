package trees;

import java.util.ArrayList;
import java.util.List;

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
        // 如果是空节点直接返回
        if(root==null){
            return res;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        return getTreeNode(nodeList,res);
    }
    /**
     * 输入一层的节点， 保存该层节点的值 递归
     * @param treeNodeList
     * @param res
     * @return
     */
    public List<List<Integer>> getTreeNode(List<TreeNode> treeNodeList, List<List<Integer>> res){
        // 子节点为空直接返回
        if (treeNodeList.isEmpty()){
            return res;
        }
        List<Integer> vals = new ArrayList<>();
        List<TreeNode> childNodes = new ArrayList<>();
        for(TreeNode node:treeNodeList){
            // 当前节点为空 遍历下一个节点
            if(node==null) {
                continue;
            }
            vals.add(node.val);
            // 保存子节点
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

