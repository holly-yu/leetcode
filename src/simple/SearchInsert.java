package simple;

/**
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * */


public class SearchInsert {
    /** 由于是有序数组，基本方法就是二分查找
     * 但本题边界情况较多，需要注意
     * 时间复杂度：O(logn)，空间复杂度：O(1)
     * */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int mid;
        // 以下两种情况是target值不位于数组区间中，但实际并不需要，仔细推敲发现：二分查找代码能处理这两种情况；长度为1的情况也可以处理。
//        if( target < nums[low]){
//            return low;
//        }
//        if (target > nums[high]){
//            return high + 1;
//        }
        while(low<=high){
            mid = (low + high) / 2;
            if( nums[mid] == target){
                return mid;
            }
            else if( nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}
