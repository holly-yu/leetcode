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
        int[] res = {1,2};
        System.out.println(res[0]);

        List<int[]> l = new ArrayList<>();
        l.add(new int[]{1,2});
        l.add(new int[]{3,4});
        l.add(new int[]{5,6});
        int[][] arr = l.toArray(new int[l.size()][2]);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0]);
        }
    }


}
