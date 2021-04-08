package hot100.simple;

/*
* 206. 反转链表
*
* 反转一个单链表。
* 示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
* */
public class ReverseList {
    public ListNode reverseList(ListNode head) {

        ListNode p = head,q = null;
        if(head == null){
            return null;
        }
        while(p != null){
            ListNode temp = p.next;
            p.next = q;
            q = p;
            p = temp;
        }
        return q;
    }

    //递归
    /*
    reverseList: head=1
    reverseList: head=2
	    reverseList: head=3
		    reverseList:head=4
			    reverseList:head=5
					终止返回
				cur = 5
				4.next.next->4，即5->4
			cur=5
			3.next.next->3，即4->3
		cur = 5
		2.next.next->2，即3->2
	cur = 5
	1.next.next->1，即2->1

	最后返回cur
	*/
    public ListNode reverseList2(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        else{
            ListNode newhead = reverseList(head.next);
            head.next.next = head;
            head.next = null; //否则可能会产生环
            return newhead;
        }
    }
}
