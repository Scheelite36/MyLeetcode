/*
 * @lc app=leetcode.cn id=237 lang=java
 *
 * [237] 删除链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // 将当前结点数据变为下一个结点的，指向下下个结点
        node.val = node.next.val;
        node.next = node.next.next;

    }
    /** from title */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


// @lc code=end

