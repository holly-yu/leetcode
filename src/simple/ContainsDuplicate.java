package simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * */

public class ContainsDuplicate {
    // 哈希表记录是否已经存在
    // 时间复杂度：O(N),空间复杂度：O(N)
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if(set.contains(nums[i])){
                return true;
            }
            else set.add(nums[i]);
        }

        return false;
    }

    /**
     * 方法二：排序
     *
     * 在对数字从小到大排序之后，数组的重复元素一定出现在相邻位置中。
     * 因此，我们可以扫描已排序的数组，每次判断相邻的两个元素是否相等，如果相等则说明存在重复的元素。
     *
     * 时间复杂度：O(NlogN)，空间复杂度：O(logN)
     * */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
