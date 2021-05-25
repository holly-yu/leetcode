package medium;

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
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *  
 *
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= start i <= end i <= 104
 * */
public class Merge {
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
        for(int k = 0; k < n - 1; k ++){
            if(intervals[k][1] >= intervals[k + 1][0]){
                if(intervals[k][1] <= intervals[k + 1][1]){
                    res[nRes ++] = new int[]{intervals[k][0], intervals[k + 1][1]};
                }
                else{
                    res[nRes ++] = intervals[k];
                }
            }
        }
    }
}
