import java.util.*;

public class test3 {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(2);
        deque.add(3);
        System.out.println(deque.remove());
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.replace(1,map.get(1),map.get(1)+1);
        System.out.println(map.get(1));
        String s = "";
        System.out.println(s=="");
    }


}
