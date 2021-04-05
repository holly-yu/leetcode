package 剑指Offer;
/*剑指 Offer 06
* 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
* 输入：head = [1,3,2]
* 输出：[2,3,1]
* */

import java.util.Stack;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}

public class ReverseList {
    public int[] reversePrint(ListNode head){

        if (head == null){
            return new int[0];
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        while(head!=null){
            stack.push(head);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for(int i = 0;!stack.isEmpty(); i++){
            result[i] = stack.pop().val;
        }
        return result;
    }

}
