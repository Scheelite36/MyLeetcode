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

        // 双指针
        // ListNode head = new ListNode();
        // ListNode temp = head;
        // while(list1 != null && list2 != null){
        //     if( list1.val <= list2.val){
        //         temp.next = list1;
        //         list1 = list1.next;
        //     }else{
        //         temp.next = list2;
        //         list2 = list2.next;
        //     }
        //     temp = temp.next;
        // }
        // if(list1 == null){
        //     temp.next = list2;
        // }else{
        //     temp.next = list1;
        // }
        // return head.next;

        // 递归
        if(list1==null){
            return list2;
        }else if(list2 == null){
            return list1;
        }else if(list1.val<list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }
}
// @lc code=end

