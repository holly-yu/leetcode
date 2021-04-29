package simple;

/**
 * 414. 第三大的数
 *
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * 示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 *
 * 示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 *
 * 示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *
 * 提示：
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 * */
public class ThirdMax {
    /**
     * 由于最小数可能是-2^31，所以初始的最小数不能用int的最小值，要用long类型的最小值。
     *
     * 并且要注意如果数组长度为2，比如[1,2]，所以需要设置一个flag记录max1/max2/max3的遍历次数。
     * 如果flag>=3，说明进行了三次及以上的赋值，说明有第三大的数：否则就没有。
     *
     * 极端测试用例：
     * [1,2,-2147483648]
     * */
    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        int flag = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
                flag ++;
            }
            else if(nums[i] > max2 && nums[i] < max1){
                max3 = max2;
                max2 = nums[i];
                flag ++;
            }
            else if(nums[i] > max3 && nums[i] < max2){
                max3 = nums[i];
                flag ++;
            }
        }
        if(flag >= 3){
            return (int)max3;
        }
        else{
            return (int)max1;
        }
    }
}
