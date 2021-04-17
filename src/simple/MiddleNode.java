package simple;

/**
 * 876. 链表的中间结点
 *
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *
 * */

public class MiddleNode {
    // 思路：快慢指针。
    // 慢指针一次走一步，快指针一次走两步，这样快指针到达尾部时，快指针正好到中点。
    public ListNode middleNode(ListNode head) {
        ListNode p = head, q = head;
        while(q != null && q.next != null){
            p = p.next;
            q = q.next.next;
        }
        return p;
    }
}
