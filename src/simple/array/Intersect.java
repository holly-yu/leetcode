package simple.array;
import java.util.*;
/**
 * 350.两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * 
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果nums1的大小比nums2小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 
 * 结语
 * 如果 nums2的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中。那么就无法高效地对 nums2进行排序，因此推荐使用方法一而不是方法二。
 * 在方法一中，nums2只关系到查询操作，因此每次读取 nums2中的一部分数据，并进行处理即可。
 * */
public class Intersect {
    /**
     * 用map来解决，具体操作如下:
     * 遍历nums1中的所有元素，把它存放到map中，其中key就是nums1中的元素，value就是这个元素在数组nums1中出现的次数。
     * 遍历nums2中的所有元素，查看map中是否包含nums2的元素，如果包含，就把当前值加入到集合list中，然后对应的value要减1。
     *
     * 最后再把集合list转化为数组即可.
     *
     * 时间复杂度为O(m+n)
     * */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i ++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i],1);             // 因为可能有多个重复的数字，因此需要记录出现的次数。
            }
            else {
                map.replace(nums1[i],map.get(nums1[i])+1);
            }
        }
        for(int j = 0; j < nums2.length; j ++){
            if(map.get(nums2[j]) != null && map.get(nums2[j]) > 0 ){
                res.add(nums2[j]);
                map.replace(nums2[j], map.get(nums2[j])-1);
            }

        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }

    /**
     * 先对两个数组进行排序，然后使用两个指针，分别指向两个数组开始的位置。
     *
     * 如果两个指针指向的值相同，说明这个值是他们的交集，就把这个值加入到集合list中，然后两个指针在分别往后移一步。
     * 如果两个指针指向的值不同，那么指向的值相对小的往后移一步，相对大的先不动，然后再比较
     * 一直重复上面的操作，直到其中一个指针不能再移动为止，最后再把集合list转化为数组即可。来看下
     *
     * 时间复杂度为O(mlogm+nlogn)
     *
     * 作者：数据结构和算法
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/?discussion=miIug2
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * */
    public int[] intersect2(int[] nums1, int[] nums2) {
        // 先对两个数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                // 如果i指向的值小于j指向的值，，说明i指向
                // 的值小了，i往后移一步
                i++;
            } else if (nums1[i] > nums2[j]) {
                // 如果i指向的值大于j指向的值，说明j指向的值
                // 小了，j往后移一步
                j++;
            } else {
                // 如果i和j指向的值相同，说明这两个值是重复的，
                // 把他加入到集合list中，然后i和j同时都往后移一步
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        //把list转化为数组
        int index = 0;
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[index++] = list.get(k);
        }
        return res;
    }

}
