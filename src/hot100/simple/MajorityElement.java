package hot100.simple;

import java.util.HashMap;
import java.util.Map;

/*
* 169. 多数元素
*
* 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1：

输入：[3,2,3]
输出：3
示例 2：

输入：[2,2,1,1,1,2,2]
输出：2

进阶：
尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
* */

public class MajorityElement {
    private Map<Integer,Integer> map = new HashMap<>();

    // 时间复杂度O(n),空间复杂度O(n)
    public int majorityElement(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else
                map.replace(nums[i],map.get(nums[i])+1);
            if (map.get(nums[i]) > nums.length / 2){
                result = nums[i];
                break;
            }
        }
        return result;
    }


    // 首先标记一个元素为结果，遍历，如果遇到重复的元素，则count+1,否则count-1；当count=0时，说明标记元素的重复数量不超过n/2，则这个标记元素不是结果。
    // 然后就把标记元素更改为当前的下一个元素，继续遍历，直到遍历完整个数组，这时的标记元素即为所求结果。
    // 实质其实就是一个众数抵消一个非众数，最后剩下的一定是众数
    // 时间复杂度O(n),空间复杂度O(1)

    public int majorityElement2(int[] nums){
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != result){
                count --;
            }
            else
                count ++;
            if (count == 0){
                result = nums[i+1];
            }
        }
        return result;
    }

    //第三种办法：首先排序，nums[n/2]的位置的元素既为结果
    //时间复杂度为O(nlogn)，空间复杂度为O(1)
}
