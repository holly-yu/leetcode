package hot100.simple;

/**
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 提示：
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 * */
public class MaxProfit {
    /**
     * 暴力解法时间会超时
     *
     * 自己的方法：
     * 首先寻找较小的数为min，从这个依次寻找maxProfit；如果遇到更小的数，把这个数记为min，继续从这个数寻找maxProfit
     * 时间复杂度O(n)，空间复杂度O(1)
     */

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxprofit = 0;
        int min = 0,max = 0;
        for(int i = 0; i < n; i ++){
            if( prices[i] >= prices[max]){
                max = i;
            }
            if( prices[i] <= prices[min]){
                min = i;
                max = i;
            }
            if( prices[max] - prices[min] > maxprofit){
                maxprofit = prices[max] - prices[min];
            }
        }

        return maxprofit; // 最开始return的是prices[max]-prices[min]，这样有可能虽然不是最大利润，但由于找到了新的最低点min，返回的结果不正确
                          // 应该使用额外变量存储结果，而不是使用数组内容相减的结果
    }

    // 官方题解：
    // 其实和自己的方法是一个原理：寻找最低价格，然后找最大利润。只不过这个题解记录的不是索引下标，而是对应的数（价格）。
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0; i < n; i ++){
            if (prices[i] < minprice){
                minprice = prices[i];
            }
            else if(prices[i] - minprice > maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }



}
