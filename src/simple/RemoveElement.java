package simple;

/**
 * 27. 移除元素
 *
 *
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * */

public class RemoveElement {

    // 我的思路类似于 283. 移动零的解法
    // 双指针：左指针一直指向下一个待处理的元素，如果遇到等于val的数，则不动；右指针遍历数组，
    //       遇到≠val的数，而左指针指向==val的数，交换两数。最后所有==val的数全在最右边
    // 时间复杂度：O(n)，空间复杂度：O(1)
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int p = 0,q = 0;
        // nums.length==1时，结果可能为空也可能为长度为1的数组，因此不能简单的用长度判断返回结果
//        if( n < 2){
//            return n;
//        }
        while(q < n){
            if( nums[p] != val){
                p ++;
            }
            else if(nums[q] != val){
                int temp = nums[p];
                nums[p] = nums[q];
                nums[q] = temp;
                p ++;
            }
            q ++;
        }
        return p;
    }

    // 由于本题对==val的数的位置并无要求，因此官方题解用了以下办法：
    // 右指针right 指向当前将要处理的元素，左指针left 指向下一个将要赋值的位置。

    //如果右指针指向的元素不等于val，它一定是输出数组的一个元素，我们就将右指针指向的元素复制到左指针位置，然后将左右指针同时右移；
    //如果右指针指向的元素等于 val，它不能在输出数组里，此时左指针不动，右指针右移一位

    //整个过程保持不变的性质是：区间[0,left) 中的元素都不等于val。当左右指针遍历完输入数组以后，left 的值就是输出数组的长度。

    public int removeElement2(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
