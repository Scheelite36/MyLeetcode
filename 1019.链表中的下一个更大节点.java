<<<<<<< HEAD
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> 04061786c6384e08093b2c1e8776ae79cf80b77c

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
<<<<<<< HEAD
    
    int count = 0;

    public int[] nextLargerNodes(ListNode head) {
        // reverse than compare with stack
        head = revsere(head);
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[count];
        while (count > 0) {
            while (!stack.isEmpty() && stack.peek() <= head.val){
                stack.pop();
            }
            res[--count] = stack.isEmpty()?0:stack.peek();
            stack.push(head.val);
            head = head.next;
        }
        return res;
    }

    private ListNode revsere(ListNode head){
        count++;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = revsere(head.next);
        head.next.next = head;
        head.next = null;
        return p;
=======
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
>>>>>>> 04061786c6384e08093b2c1e8776ae79cf80b77c
    }
}
// @lc code=end

