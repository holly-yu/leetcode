package hot100.simple;

/*
* 21. 合并两个有序链表
* 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
* 输入：l1 = [1,2,4], l2 = [1,3,4]
* 输出：[1,1,2,3,4,4]
* */

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val,ListNode next){this.val = val;this.next = next;}
}

public class MergeTwoLists {
    // 每次把指针指向未排序节点中最小的两个中的较小节点（把这个节点加入新合并链表）
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode prehead = new ListNode(-101);
        ListNode prev = prehead;
        while (l1!=null && l2 != null){
            if (l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }
            else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1==null ? l2 : l1;

        return prehead.next;


    }

}
