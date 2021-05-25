/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
  let left = 0, right = nums.length - 1;
  let ans = [-1, -1];
  if (nums.length == 0) {
    return ans;
  }
  while (left < right) {
    let mid = Math.floor((left + right) / 2);
    if (nums[mid] >= target) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }
  if (nums[right] != target) {
    return ans;
  }
  ans[0] = right;  

  left = 0; 
  right = nums.length - 1;
  while (left < right) {
    let mid = Math.floor((left + right + 1) / 2);
    if (nums[mid] <= target) {
      left = mid;
    } else {
      right = mid - 1;
    }
    
  }
  ans[1] = right;

  return ans;
};

var nums = [5,7,7,8,8,10]
var target = 8

console.log(searchRange(nums,target))