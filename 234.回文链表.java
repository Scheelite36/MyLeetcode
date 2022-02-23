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
        ListNode temp = null;
        ListNode h = head;
        while(head != null){
            ListNode node = new ListNode(head.val,temp);
            head = head.next;
            temp = node;
        }
        while(h.next != null){
            if(h.val != temp.val){
                return false;
            }
            h = h.next;
            temp =temp.next;
        }
        return true;
    }
}
// @lc code=end

