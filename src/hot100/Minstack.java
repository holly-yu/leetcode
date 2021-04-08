package hot100;

/*
* 155. 最小栈
* 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
* */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Minstack {
    private List<Integer> stack1= new ArrayList<>();
    private List<Integer> stack2= new ArrayList<>();

    public Minstack(){

    }

    public void push(int val){
        this.stack1.add(val);
        if (this.stack2.isEmpty()){
            this.stack2.add(val);
        }
        else {
            if (val <= this.stack2.get(this.stack2.size()-1)){
                this.stack2.add(val);
            }
        }
    }

    public void pop(){
        if (!this.stack1.isEmpty() && !this.stack2.isEmpty() && this.stack1.get(this.stack1.size()-1).equals(this.stack2.get(this.stack2.size()-1))){
            this.stack2.remove(this.stack2.size()-1);
        }
        if (!this.stack1.isEmpty()){
            this.stack1.remove(this.stack1.size()-1);
        }



    }

    public int top(){
        return this.stack1.get(this.stack1.size()-1);
    }

    public int getMin(){
        return this.stack2.get(this.stack2.size()-1);
    }

    public static void main(String[] args) {
        Minstack minstack = new Minstack();
        minstack.push(-2);
        minstack.push(0);
        minstack.push(-3);
        System.out.println(minstack.getMin());
        minstack.pop();
        System.out.println(minstack.top());

        System.out.println(minstack.getMin());
        minstack.pop();
        System.out.println(minstack.getMin());
    }

}
