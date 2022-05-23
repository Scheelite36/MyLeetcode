import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1019 lang=java
 *
 * [1019] 链表中的下一个更大节点
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
    public int[] nextLargerNodes(ListNode head) {
        ListNode cur = head, next = head.next;
        List<Integer> indexList = new ArrayList<>();
        while(cur.next != null){
            if (next == null){
                indexList.add(0);
                cur = cur.next;
                next = cur.next;
                continue;
            }
            if (next.val > cur.val){
                indexList.add(next.val);
                cur = cur.next;
                next = cur.next;
            }else{
                next = next.next;
            }
        }
        indexList.add(0);
        int[] res = new int[indexList.size()];
        for (int i=0; i < indexList.size(); i++){
            res[i] = indexList.get(i);
        }
        return res;
    }
}
// @lc code=end

