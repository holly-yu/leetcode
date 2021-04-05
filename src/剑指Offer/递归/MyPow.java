/*剑指Offer
*实现函数double Power(double base, int exponent)，
* 求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
* */

/*本题使用快速幂法 可将时间复杂度降低至 O(log2 n)。
* 二分推导： x^n = x^{n/2} * x^{n/2} = (x^2)^{n/2}
* 分为两种情况：
* 当 n 为偶数： x^n = (x^2)^{n//2} ；
当 n 为奇数： x^n = x * (x^2)^{n//2}，即会多出一项 x ；
*/
package 剑指Offer.递归;

public class MyPow {
    public double myPow(double x,int n){
        if ( x == 0){
            return 0;
        }

        double result = 1.0;
        long b = n;
        if ( n < 0){
            x = 1 / x;
            b = -b;
        }
       while ( b > 0 ){
           if ( b % 2 == 1){  //每当 n 为奇数时，将多出的一项 x 乘入 res
               result *= x;
           }
           x = x * x;
           b /= 2;
        }
       return result;
    }
}
