package 剑指Offer;/*
* 剑指Offer03
* 找出数组中重复的数字。
*
*在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
* 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
* */

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class findRepeatNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strings = null;
        strings = input.nextLine().split(" ");
        int nums[] = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.valueOf(strings[i]);
        }
        System.out.println(findRepeatNumber(nums));
    }

    //时间复杂度O(n),空间复杂度O(1)
    public static int findRepeatNumber(int[] nums){
        int repeat = -1;

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                repeat = nums[i];
            }
            else
                set.add(nums[i]);
        }
        return repeat;
    }
}
