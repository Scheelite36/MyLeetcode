/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        //快慢指针 找到中间
        ListNode fast=head, slow=head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // fast为null成立，说明是奇数个
        if(fast!=null){
            slow = slow.next;
        }
        // 反转数组
        slow = reverse(slow);

        while(slow != null){
            // 比较节点的值
            if(slow.val!=head.val){
                return false;
            }
            slow = slow.next;
            head= head.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        // 建议多看 多理解
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
// @lc code=end

