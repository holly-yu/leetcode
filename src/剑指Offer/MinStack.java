/*
剑指Offer 30.包含min函数的栈
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素
的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。*/

//本题难点： 将 min() 函数复杂度降为 O(1)O(1) ，可通过建立辅助栈实现；
//        数据栈 AA ： 栈 AA 用于存储所有元素，保证入栈 push() 函数、出栈 pop() 函数、获取栈顶 top() 函数的正常逻辑。
//        辅助栈 BB ： 栈 BB 中存储栈 AA 中所有 非严格降序 的元素，则栈 AA 中的最小元素始终对应栈 BB 的栈顶元素，即 min() 函数只需返回栈 BB 的栈顶元素即可。

package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MinStack {
    private int top = -1;
    private List<Integer> list = new ArrayList<Integer>();
    private Stack<Integer> stack = new Stack<Integer>();

    public MinStack(){

    }

    public void push(int x){
        if (stack.isEmpty() || x <= stack.lastElement()){ //一定要<=
            stack.push(x);         //辅助栈只存储非严格降序的元素
        }
        this.top ++;
        list.add(x);
    }

    public void pop(){
        if(this.top!=-1)
            //Java 代码中，由于 Stack 中存储的是 int 的包装类 Integer ，因此需要使用 equals() 代替 == 来比较值是否相等。
            if (list.get(this.top).equals(stack.lastElement())){ //栈顶元素相等才删除辅助栈的栈顶元素 // == 无法判断，只能使用equals判断
                stack.pop();
            }
            list.remove(this.top);
            this.top -- ;


    }

    public int top(){
        return list.get(this.top);
    }

    public int min(){
        return stack.lastElement();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(9);
        minStack.push(10);
        minStack.push(7);
        minStack.push(3);
        minStack.push(5);
        System.out.println(minStack.min());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.min());

    }

}
