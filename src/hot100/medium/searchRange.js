/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * 
 * 
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */



/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */


/**
 * 基本思路：二分查找，分别查找上下界
 *  
 */
var searchRange = function(nums, target) {
  let left = 0, right = nums.length - 1;
  let ans = [-1, -1];
  if (nums.length == 0) {
    return ans;
  }
  // 寻找左边界
  while (left < right) {       //结束循环时，left == right
    let mid = Math.floor((left + right) / 2);
    if (nums[mid] < target) {
      // [mid + 1, right]
      left = mid + 1;
    } else if(nums[mid] == target){
      // [left, mid]
      right = mid;
    } else{
      // nums[mid] > target
      // [left, mid - 1]
      right = mid - 1;
    }
  }

  if (nums[right] != target) {  //检查下寻找的target是否在数组中
    return ans;
  }
  ans[0] = right;     // left==right,所以都可以

  // 寻找右边界
  left = 0; 
  right = nums.length - 1;
  while (left < right) {
    let mid = Math.floor((left + right + 1) / 2);  // 这里取上界是为了让mid向右靠，left往右走，否则无法跳出循环
    if (nums[mid] < target) {
      // [mid + 1, right]
      left = mid + 1;
    } else if(nums[mid] == target){
      // [mid, right]
      left = mid;
    } else{
      // nums[mid] > target
      // [left, mid - 1]
      right = mid - 1;
    }
    
  }
  ans[1] = right;

  return ans;

};
