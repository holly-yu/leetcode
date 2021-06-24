package simple.array;


/**
 * 189. 旋转数组
 * 
 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 *
 * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释: 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 
 *
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * */
public class Rotate {
    /**
     * 自己的办法：
     *  基本方法是，记录当前的数，把前一个数赋给当前的位置，如此循环，直到所有数都得到了新值；
     *  经观察可发现，遍历的位置会回到之前遍历过的位置，这时候就要把位置+1。
     *  注意：要注意取余，否则会越界。
     * */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k == 0 || n == 1){
            return;
        }

        int i = 0;
        int count = 0;
        int temp = nums[0];
        int cur;
        int flag = 0;
        while(count <n){
            int j = (i+k)%n;
            cur = nums[j];
            nums[j] = temp;
            temp = cur;
            i = j;
            if(i== flag){
                i  = (i+1)%n;
                temp = nums[i];
                flag = i;     // 要注意记录上一个二次遍历过的下一个初始位置
            }
            count ++;
        }
    }

    /**
     * 官方方法：反转整个数组，反转前K个数，反转后边剩余的数。
     * */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        if(k == 0 || n == 1){
            return;
        }
        reverse(nums,0,n -1);
        reverse(nums,0,k%n - 1);
        reverse(nums,k%n,n-1);


    }
    public void reverse(int[] nums, int start ,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }

    }
}
