package simple;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 *
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
 *
 * 示例1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * */

public class ContainsNearbyDuplicate {
    /**
     * 维护一个滑动窗口，遍历比较每个数和它后边（1~k）个数
     *
     * 缺点是时间复杂度很高，O(n^2).空间复杂度O(1).
     * */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length - 1; i ++){
            for(int j = i + 1; j <= i + k && j < nums.length; j ++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }

        }

        return false;
    }

    /**
     * 散列表：用散列表来维护这个kk大小的滑动窗口。
     *
     * 在之前的方法中，我们知道了对数时间复杂度的 搜索 操作是不够的。在这个方法里面，我们需要一个支持在常量时间内完成 搜索，删除，插入 操作的数据结构，那就是散列表。这个算法的实现跟方法二几乎是一样的。
     *
     * 遍历数组，对于每个元素做以下操作：
     *    在散列表中搜索当前元素，如果找到了就返回 true。
     *    在散列表中插入当前元素。
     *    如果当前散列表的大小超过了 kk， 删除散列表中最旧的元素。
     * 返回 false。
     *
     * 时间复杂度：O(n)，空间复杂度：O(min(n,k))
     * */

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
