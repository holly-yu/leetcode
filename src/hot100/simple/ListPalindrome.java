package hot100.simple;

/*
* 234. 回文链表
*
* 请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

* */

public class ListPalindrome {
    public boolean isPalindrome(ListNode head) {
        // 思路：首先遍历链表得到链表长度，然后把链表的前一半反转，最后把链表前一半和后一半逐个进行比较。

        boolean res = true;
        ListNode p = head;
        int len = 0;
        while( p != null){
            len ++;
            p = p.next;
        }
        ListNode l1,l2;
        if( len%2 == 1){
            ListNode b = head, a = null,c = head.next;
            for( int i = 0; i < len/2 ; i ++ ){
                ListNode temp = b.next;
                b.next = a;
                a = b;
                b = temp;
                c = temp.next;
            }
            l1 = a;
            l2 = c;
        }
        else{
            ListNode b = head, a = null;
            for(int i = 0; i < len/2 ; i ++){
                ListNode temp = b.next;
                b.next = a;
                a = b;
                b = temp;
            }
            l1 = a;
            l2 = b;
        }

        while( l1 != null && l2 != null){

            if( l1.val != l2.val){
                res = false;
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListPalindrome l = new ListPalindrome();
        ListNode head = new ListNode();
        head.val = 1;
        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(1);
        System.out.println(l.isPalindrome(head));


    }
}
