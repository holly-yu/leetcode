package simple.array;

/**
* 283. 移动零
*
* 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

* */
public class MoveZeros {
    //其实和左右指针一个原理
    public void moveZeroes(int[] nums) {
        int count = 0;
        int i = 0;
        while(i + count < nums.length){
            nums[i] = nums[i+count];
            if(nums[i] == 0){  // 如果当前数字==0，零的个数count+1, i指针-1再+1，等于原地不动，当前元素未处理为非零元素；下次再次处理当前元素，直到非零
                count ++;
                i -= 1;
            }
            i ++;
        }
        while(i < nums.length){
            nums[i] = 0;
            i ++;
        }
    }

    //思路及解法:
    //使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
    //右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。

    //注意到以下性质：
    //左指针左边均为非零数；
    //右指针左边直到左指针处均为零。
    //因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。

    public void moveZeroes2(int[] nums){
        int left = 0, right = 0;
        while(right < nums.length){
            if (nums[right] != 0){  // right指向的数字不为零交还给left,left就可以向右移动，处理下一个未处理数字
                swap(nums,left,right);
                left ++;
            }

            right ++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
