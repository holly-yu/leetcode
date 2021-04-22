package simple;


/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 *
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 * */
public class MergeArray {

    /**
     * 基本思路是在数组nums1尾部归并，从尾部开始，每次从nums1和nums2 最后一个待处理数 中找一个更大的放入nums1尾部。
     *
     *
     * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mm = m - 1,nn = n - 1,i = 0;
        int flag = 0;
        while( i <= m + n){
            // 这两个if是为了判断两个列表是否有一个已经处理完毕
            // 如果是nums1先处理完毕，只需要把nums2未处理的数 按位 赋给 nums1即可；
            // 如果是nums2先处理完毕，nums1的未处理数 已经不需要继续处理，原地不动即可。
            if( mm == -1 && nn != -1){
                flag = 1;
                break;
            }
            if( mm != -1 && nn == -1){
                break;
            }

            if(nums1[mm] >= nums2[nn]){
                nums1[m + n - 1 - i] = nums1[mm];
                mm --;
            }
            else{
                nums1[m + n - 1 - i] = nums2[nn];
                nn --;
            }
            i++;
        }

        if( flag == 1){
            for(int j = nn; j >= 0; j --){
                nums1[j] = nums2[j];
            }
        }

    }
}
