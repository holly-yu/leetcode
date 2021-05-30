/**
 * 39. 组合总和
 * 
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */


/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    
  let ans = [];
  var dfs = function(combine, target, idx){
      // 结束递归条件为搜索完candidates数组或target<=0(找到结果组)   
      if(idx == candidates.length){
          return;
      }
      if(target == 0){
          ans.push(combine);
          return;
      }
      // 跳过当前数
      dfs(combine, target, idx + 1);
      // 加入当前数
      if(target-candidates[idx] >= 0){
          dfs([...combine, candidates[idx]], target-candidates[idx], idx);
      }
      
  }

  dfs([], target, 0);
  return ans;
  
  
};