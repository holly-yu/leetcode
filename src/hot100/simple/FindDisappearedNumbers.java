package hot100.simple;

import java.util.ArrayList;
import java.util.List;

/*
* 448. 找到所有数组中消失的数字
*
* 给定一个范围在 1 ≤ a[i] ≤ n (n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

示例:
输入:
[4,3,2,7,8,2,3,1]
输出:
[5,6]

* */

public class FindDisappearedNumbers {

    // 思路：一般我们用哈希表记录，这道题不能用额外的空间，所以把数组本身作为一个 哈希表 存储数字是否出现的信息

    // 数的范围是[1,n],数组下标范围是[0,n-1]。
    // 遍历数组，如果某个数字出现了，就将它作为下标（要减1）对应的数+n（由于修改会影响原本的数字，所以要取余数进行计算）
    // 遍历完成后，未出现的数字作为数组下标中的数没有进行过+n运算，会<=n，而出现过的数字>n，这样就找到了所有数组中消失的数字

    // 时间复杂度O(n),空间复杂度O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l = new ArrayList<Integer>();
        int n = nums.length;
        for( int i = 0; i < n; i ++){
            nums[(nums[i] - 1) % n ] += n;
        }
        for( int i = 0; i < n; i ++){
            if(nums[i] <= n){
                l.add(i+1);
            }
        }
        return l;
    }
}
