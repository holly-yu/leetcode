/*
剑指Offer 59-Ⅱ. 队列的最大值
请定义一个队列并实现函数 max_value 得到队列里的最大值，
要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1
* */

/*如何高效实现一个始终递减的队列呢？我们只需要在插入每一个元素 value 时，
从队列尾部依次取出比当前元素 value 小的元素，直到遇到一个比当前元素大的元素 value' 即可。
保证新插入元素在递减队列中，前边都是比自己大的元素，后边没有元素。
* */

package 剑指Offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxQueue {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Deque<Integer> deque = new LinkedList<>();

    public MaxQueue() {

    }

    public int max_value() {
        if (queue1.isEmpty()){
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {             //保证单调递减队列
        while (!deque.isEmpty() && value > deque.getLast()){
            deque.pollLast();
        }
        queue1.add(value);
        deque.addLast(value);
    }

    public int pop_front() {
        if (queue1.isEmpty()){
            return -1;
        }
        if (queue1.element().equals(deque.element())){
            deque.remove();
        }
        return queue1.remove();
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
//        maxQueue.push_back(1);
//        maxQueue.push_back(2);
//        System.out.println(maxQueue.deque);
//        System.out.println(maxQueue.queue1);
//        System.out.println(maxQueue.max_value());
//        System.out.println(maxQueue.pop_front());
//        System.out.println(maxQueue.deque);
//
//        System.out.println(maxQueue.queue1);

        System.out.println(maxQueue.max_value());
    }
}
