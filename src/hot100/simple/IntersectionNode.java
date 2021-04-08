package hot100.simple;
/*
* 160. 相交链表
*
* 编写一个程序，找到两个单链表相交的起始节点。
*/



public class IntersectionNode {
    // 从某一个节点开始相交，说明此节点之后两链表节点相同。首先寻找两列表的长度差，让两个指针从”同一起点“（之后走相同长度）开始出发，直到遇到两指针相同的节点即为结果。
    // 时间复杂度O(n),空间复杂度O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode res = null;
        if(headA == null || headB == null){
            res = null;
        }
        ListNode la = headA;
        ListNode lb = headB;
        int countA = 0;
        int countB = 0;
        while( la != null){
            countA ++;
            la = la.next;
        }
        while( lb != null){
            countB ++;
            lb = lb.next;
        }
        la = headA;
        lb = headB;
        if(countA>countB){
            for( int i = 0; i < countA-countB; i ++){
                la = la.next;
            }
        }
        else{
            for( int i = 0; i < countB-countA; i ++){
                lb = lb.next;
            }
        }
        while( la != null && lb != null){
            if(la == lb){
                res = la;
                break;
            }
            la = la.next;
            lb = lb.next;
        }
        return res;
    }
}
