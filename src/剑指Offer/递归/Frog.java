/*剑指Offer 10-Ⅱ. 青蛙跳台阶问题
* 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
*/
package 剑指Offer.递归;

public class Frog {
    // 第一种办法：最后一次跳台阶有可能是一次跳上1级，也可能是跳上2级台阶。把所有办法分为这两种，f(n-1) + f(n-2)
    // 时间复杂度为O(2^n)
    public int numWays(int n){
        if (n==0 || n == 1){
            return 1;
        }
        else {
            return (numWays(n-1) + numWays(n-2)) % 1000000007;
        }
    }

    // 第二种办法：记忆化递归
    // 把计算过的f(n)存储起来，用到了直接取，避免重复计算。
    final int mod=1000000007;
    private int[] F=new int[105];
    public int numWays2(int n) {
        if(F[n]!=0)
            return F[n];
        if(n==1 || n==0 )
            return F[n]=1;
        return F[n]=(numWays2(n-1)+numWays2(n-2))%mod;
    }

    // 第三种办法：对递归进行改进，减小空间复杂度和时间复杂度。
    // 时间复杂度为O(n)
    public int numWays3(int n){
        int a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            // a = f(i),b = f(i+1),sum = f(i+2)
            int sum = ( a + b ) % 1000000007;
            a = b;          //a = f(i+1)
            b = sum;        //b = f(i+2)
        }
        return a;
    }

    // 第四种办法：动态规划


}
