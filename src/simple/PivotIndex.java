package simple;

/**
 * 724. 寻找数组的中心下标
 *
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心下标” 的方法。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
 * 注意：中心下标可能出现在数组的两端。
 *
 * 示例 1：
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 (1 + 7 + 3 = 11)，
 * 右侧数之和 (5 + 6 = 11) ，二者相等。
 *
 * 示例 2：
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 *
 * 示例 3：
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 下标 0 左侧不存在元素，视作和为 0 ；
 * 右侧数之和为 1 + (-1) = 0 ，二者相等。
 *  
 *
 * 提示：
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 * */

public class PivotIndex {
    /**
     * 思路：
     * 首先遍历一遍算所有数和记为right，left设置为0;
     * 再遍历一遍，每多遍历一个数left加上这个数，right减去这个数；
     * 注意：left加的是当前坐标的前一个数，right减去的是当前坐标的数；另外对于第一个数要提前处理，因为此时right减了，left没有加。
     * */
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int res = -1;
        int flag = 0;
        int left = 0, right = 0;
        for(int i = 0; i < n; i ++){
            right += nums[i];
        }
        right -= nums[0];  // 此时right减了，left没有加。
        if(left == right){
            res = 0;
            flag = 1;
        }
        if(flag != 1){  // 如果在第一个位置已经获得结果，则不需要继续进行循环
            for(int i = 1; i < n; i ++){
                left += nums[i-1];
                right -= nums[i];
                if(left == right){
                    res = i;
                    flag = 1;
                    break;
                }
            }
        }

        return res;
    }
}
