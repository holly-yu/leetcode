package simple;

/**
 * 118. 杨辉三角
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * */

import java.util.ArrayList;
import java.util.List;

public class GenerateTri {
    /**
     * 思路：杨辉三角的每个数，其实就是组合数C(n,m)(n是行，m是列)，依次求得即可。
     * 问题：遇到的主要问题是，求组合数的过程中，由于乘积过大，超出了int的范围，甚至也超出了long的范围，
     *      最后使用了组合数的另一个性质：
     *      C(n,m) = C(n,n-m)
     *      这样减小了计算（m最大也就是n/2），可以不超过long的表示范围。
     *
     *      但问题也没有彻底解决：如果整数超出long的表示范围该怎么表示？
     * */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                l.add(C(i,j));
            }
            res.add(l);
        }
        return res;
    }

    public int C(int n, int m){
        long mm = 1, nn = 1;
        if ( m > n / 2){
            m = n - m;
        }
        for(int i = 1; i <= m; i ++){
            nn *= (n + 1) - i;
            mm *= i;
        }
        System.out.println(nn);
        System.out.println(mm);
        return (int)(nn/mm);
    }


}
