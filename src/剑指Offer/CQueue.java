package 剑指Offer;

/*
*剑指 Offer 09. 用两个栈实现队列
* 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
* 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
* */

import java.util.Stack;

class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack1.isEmpty()&&stack2.isEmpty()){
            return -1;
        }
        if (stack2.isEmpty()){           //必须等stack2空了才能继续往里添加元素，否则会乱了顺序
            while(!stack1.isEmpty()){
                int element = stack1.pop();
                stack2.push(element);
            }
        }
        return stack2.pop();


    }
}
