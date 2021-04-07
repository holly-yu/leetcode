package hot100.simple;

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
            System.out.println(l1.val);
            System.out.println(l2.val);
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
