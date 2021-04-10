package hot100.simple;

import java.util.Hashtable;

public class SingleNumber {

    // 哈希表暴力解决
    public int singleNumber(int[] nums){
        Hashtable<Integer, Integer> h = new Hashtable<Integer, Integer>();
        int result = -1000;
        for (int i = 0; i < nums.length; i++) {
            if (h.containsKey(nums[i])){
                h.replace(nums[i],2);
            }
            else 
                h.put(nums[i],1);
        }
        for(int i = 0; i < nums.length; i++){
            if (h.get(nums[i]) == 1){
                result = nums[i];
            }
        }
        return result;
    }

    // 位运算
    /*
    * 异或运算有以下三个性质。

    1.任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
    2.任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
    3.异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。

     数组中的全部元素的异或运算结果总是可以写成如下形式：

    (a1	⊕a1)⊕(a2 ⊕a2)⊕⋯⊕(am	⊕am)⊕am+1 = 0⊕0⊕⋯⊕0⊕am+1 = am+1


    *
    *
    * */
    public int singleNumber2(int[] nums){
        int single = 0;
        for (int num:nums){
            single ^= num;
        }
        return single;
    }
}
