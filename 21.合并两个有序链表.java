/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while(list1 != null && list2 != null){
            if( list1.val <= list2.val){
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
        }
        if(list1 == null){
            temp.next = list2;
        }else{
            temp.next = list1;
        }
        return head.next;
    }
}
// @lc code=end

