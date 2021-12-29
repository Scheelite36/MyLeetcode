/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 双指针
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n - 1; i++) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
        // 两次遍历
    //     ListNode dummy = new ListNode(0, head);
    //     int length = getLength(head);
    //     ListNode cur = dummy;
    //     for (int i = 1; i < length - n + 1; i++) {
    //         cur = cur.next;
    //     }
    //     cur.next = cur.next.next;
    //     return dummy.next;
    // }

    // public int getLength(ListNode node) {
    //     int length = 0;
    //     while (node != null) {
    //         node = node.next;
    //         length++;
    //     }
    //     return length;
    }
}
// @lc code=end
