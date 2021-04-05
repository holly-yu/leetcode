// 排序数组中的搜索问题，首先想到 二分法 解决。

package 剑指Offer;

public class Search {
    public int search(int[] nums,int target){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                result ++;
            }
        }
        return result;
    }


    //二分查找target的左右边界，时间复杂度为log2n
    // 应用两次二分，分别查找 right 和 left ，最终返回 right - left - 1 即可。

    /*
    若 nums[m] = target ，则右边界 right 在闭区间 [m+1, j] 中；左边界 left 在闭区间 [i, m-1] 中。因此分为以下两种情况：
    若查找 右边界 right ，则执行 i = m + 1；（跳出时 i 指向右边界）
    若查找 左边界 left ，则执行 j = m - 1 ；（跳出时 j 指向左边界）
     */
    public int search2(int[] nums,int target){
        if (nums.length == 0){
            return 0;
        }
        int i = 0,j= nums.length-1;
        while ( i<=j){
            int  mid = (i + j) /2;
            if (nums[mid]>=target){
                j = mid - 1;
            }
            else {
                i = mid + 1;
            }
        }
        int left = j;

        i = 0;
        j = nums.length-1;
        while( i <= j){
            int mid = (i+j) /2;
            if (nums[mid] > target){
                j = mid -1;
            }
            else
                i = mid + 1;
        }
        int right = i;

        return right - left - 1;
    }

    /*
     * 面试题53 - II. 0～n-1 中缺失的数字
     排序数组中的搜索问题，首先想到 二分法 解决。
    根据题意，数组可以按照以下规则划分为两部分。
    左子数组： nums[i] = i ；
    右子数组： nums[i] != i ；
    */
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length-1;
        while (i <= j){
            int mid = (i + j) / 2;
            if (nums[mid] == mid){
                i = mid + 1;
            }
            else
                j = mid - 1;
        }
        //跳出时i指向右子数组的首位元素，j指向左子数组末尾元素
        return i;
    }


    /*在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    */

    //解题思路是：每个数的右下角的数字一定比它大，从右上角数字开始比较查找。
    //时间复杂度为：O(n+m),行下标最多增加n次，列下标最多减少m次。
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0){
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0, j = m - 1;
        while ( i <= n-1 && j >= 0){
            if ( target == matrix[i][j] ){
                return true;
            }
            else if ( target < matrix[i][j] ){
                j--;
            }
            else
                i ++;

        }
        return false;

    }
}
