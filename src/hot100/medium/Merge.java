package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= start i <= end i <= 104
 * */
public class Merge {
    /**
     * 暴力排序解法：
     *    1.首先排序，按start,end排序
     *    2.首先把第一个数组放入结果数组，对intervals数组进行遍历（从第二个开始），如果和结果数组中的数组重叠，就进行合并，
     *      对结果数组进行更改；若无重叠，则把结果数组当前的数组放入结果数组，然后继续重复 2.
     *
     *    时间复杂度为O(n^2),空间复杂度为O(n^2).
     * */
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if( n == 1){
            return intervals;
        }
        int[][] res = new int[n][2];
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1 - i; j ++){
                if(intervals[j][0] > intervals[j + 1][0]){
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
                if(intervals[j][0] == intervals[j + 1][0] && intervals[j][1] > intervals[j + 1][1]){
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }

        int nRes = 0;
        res[0] = intervals[0];
        for(int k = 1; k < n; k ++){
            if(intervals[k][0] <= res[nRes][1]){
                if(res[nRes][1] <= intervals[k][1]){
                    res[nRes][1] = intervals[k][1];
                }
            }
            else{
                if( k  <= n - 1){
                    res[++nRes] = intervals[k];
                }

            }
        }

        int[][] RES = new int[nRes+1][2];
        for(int l = 0; l < nRes + 1; l ++){
            RES[l] = res[l];
        }

        return RES;
    }


    /**
     * 官方题解用的是一样的思路，只不过使用了Array.sort()，时间复杂度减少了。
     * 时间复杂度：O(nlogn)，其中 n 为区间的数量。除去排序的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的 O(n\log n)O(nlogn)。
     *
     * 空间复杂度：O(logn)，其中 n 为区间的数量。这里计算的是存储答案之外，使用的额外空间。O(logn) 即为排序所需要的空间复杂度。
     */
    public int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {   // 这段代码应该练习一下
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


}
