package hot100.medium;

import java.util.*;

/**
 * 46. 全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *  
 *
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * */
public class Permute {
    /**
     * 回溯算法
     * */
    public List<List<Integer>> permute(int[] nums) {
    int n = nums.length;
        List<List<Integer>> results = new ArrayList<List<Integer>>();  
        backtrack(results, new ArrayList<Integer>(), 0, nums);
        
        return results;
    }

    public void backtrack(List<List<Integer>> results, List<Integer> res, int index, int[] nums){
        int n = nums.length;
        if(index == n){
            results.add(new ArrayList<>(res));
//            results.add(res);  // 这样不会分配新地址，results中所有res是同一地址，所以结果不对。必须 new。
        }

        for(int i = 0; i < n; i++){
            if(!res.contains(nums[i])){
                res.add(nums[i]);
                
                backtrack(results, res, index + 1, nums);
                res.remove(index);
            }

            
        }
            
    }

    public static void main(String[] args) {
        Permute per = new Permute();
        List<List<Integer>> lists = per.permute(new int[]{1,2,3});
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.println(list.get(j));
            }
//            System.out.print("\n");
        }
    }
}
