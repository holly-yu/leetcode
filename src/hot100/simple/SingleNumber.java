package hot100.simple;

import java.util.Hashtable;

/**
 * 136. 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * */

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
