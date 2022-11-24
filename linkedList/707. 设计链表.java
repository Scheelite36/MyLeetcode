package linkedList;

import java.util.List;

import javax.sound.midi.MidiSystem;

/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是
 * 0-index 的。
 * 
 * 在链表类中实现这些功能：
 * 
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 
 * 的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index
 * 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *  
 * 
 * 示例：
 * 
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2); //链表变为1-> 2-> 3
 * linkedList.get(1); //返回2
 * linkedList.deleteAtIndex(1); //现在链表是1-> 3
 * linkedList.get(1); //返回3
 * 
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 链表方法
 */
class ListNode {
    ListNode next;
    int val;
    ListNode(int val, ListNode next){
        this.next = next;
        this.val = val;
    }
    ListNode(){}
}

class MyLinkedList {
    private ListNode dummy = new ListNode();
    private int cnt;

    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if (index < 0 || index >= cnt) {
            return -1;
        }
        ListNode t = dummy.next;
        while(index-- > 0 && t != null){
            t = t.next;
        }
        return t.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);;
    }
    
    public void addAtTail(int val) {
        addAtIndex(cnt, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index > cnt) {
            return;
        }
        ListNode t = dummy;
        while(index-- >0){
            t = t.next;
        }
        ListNode n = new ListNode(val, t.next);
        t.next = n;
        cnt++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= cnt) {
            return;
        }
        ListNode t = dummy;
        while(index-- >0){
            t = t.next;
        }
        t.next = t.next == null ? null : t.next.next;
        cnt--;
    }
}
/**
 * 数组方法
 */
class MyLinkedList2 {
    int[] l;
    int[] next;
    int idx;
    int head;
    int cnt;

    public MyLinkedList2() {
        l = new int[1000];
        next = new int[1000];
    }
    
    public int get(int index) {
        if (index < 0 || index >= cnt){
            return -1;
        }
        int t = head;
        while (index-- > 0){
            t = next[t];
        }
        return l[t];
    }
    
    public void addAtHead(int val) {
        l[idx] = val;
        next[idx] = head;
        head = idx;
        idx++;
        cnt++;
    }
    
    public void addAtTail(int val) {
        addAtIndex(cnt, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > cnt){
            return;
        }
        if (index == 0){
            addAtHead(val);
            return;
        }
        int t = head;
        while(--index > 0){
            t = next[t];
        }
        l[idx] = val;
        next[idx] = next[t];
        next[t] = idx;
        idx++;
        cnt++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= cnt){
            return;
        }
        if (index == 0){
            head = next[head];
        }else{
            int t = head;
            while(--index > 0){
                t = next[t];
            }
            next[t] = next[next[t]];
        }
        cnt--;
    }
    public static void main(String[] args) {
        MyLinkedList2 m = new MyLinkedList2();
        m.addAtHead(1);
        m.addAtTail(3);
        m.addAtIndex(1, 2);
        m.get(1);
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */