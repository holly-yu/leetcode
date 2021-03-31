package hot100;

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
