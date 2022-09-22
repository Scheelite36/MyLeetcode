package linkedList;

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
class MyLinkedList {
    int[] l;
    int[] next;
    int idx = 1;
    int head;
    int tail;

    public MyLinkedList() {
        l = new int[1000];
        next = new int[1000];
    }
    
    public int get(int index) {
        int i = head;
        while(index-- > 0 &&  i != tail){
            i = next[i];
        }
        return index > 0 ? -1 : l[i];
    }
    
    public void addAtHead(int val) {
        // 头节点为0 说明链表没有值
        if (head == 0){
            tail = idx;
        }
        l[idx] = val;
        next[idx] = head;
        head = idx;
        idx++;
    }
    
    public void addAtTail(int val) {
        if (tail == 0){
            head = idx;
            addAtHead(val);
            return;
        }
        l[idx] = val;
        next[tail] = idx;
        tail = idx;
        idx++;
    }
    
    public void addAtIndex(int index, int val) {
        // 如果加的是头节点
        if (index == 0) {
            addAtHead(val);
            return;
        }

        int i = head;
        while(--index>0 && tail != i){
            i = next[i];
        }
        // 如果加的是尾巴
        if (tail == i){
            addAtTail(val);
            return;
        }
        // 中间节点
        l[idx] = val;
        next[idx] = next[i];
        next[i] = idx;
        idx++;
    }
    
    public void deleteAtIndex(int index) {
        // 删的是头部
        if (index == 0){
            // l[head] = 0;
            head = next[head];
            return;
        }
        int i = head;
        while(--index > 0 && tail != i){
            i = next[i];
        }
        // 删的是尾巴
        if (i == tail){
            tail = i;
            return;
        }
        // 删其他
        next[i] = next[next[i]];
    }
    public static void main(String[] args) {
        MyLinkedList m = new MyLinkedList();
        // m.addAtHead(1);
        // m.addAtTail(3);
        // m.addAtIndex(1, 2);
        // System.out.println(m.get(1));
        // m.deleteAtIndex(1);
        // System.out.println(m.get(1));

        m.addAtHead(5);
        m.addAtIndex(1, 2);
        System.out.println(m.get(1));

        // m.addAtHead(4);
        // m.get(1);
        // m.addAtHead(1);
        // m.addAtHead(5);
        // m.deleteAtIndex(3);
        // m.addAtHead(7);
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