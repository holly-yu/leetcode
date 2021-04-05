package 剑指Offer;

/*
请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
*/

/*
java中有三种移位运算符
 <<:左移运算符，num << 1,相当于num乘以2

 >>:右移运算符，num >> 1,相当于num除以2

 >>>:无符号右移，忽略符号位，空位都以0补齐
*/


//时间复杂度为log2(N)，移位实质上是n/2。
public class HWeight {
    public int hamminWeight(int n){
        int result = 0;
        while(n!=0){
            result += n & 1;
            n = n >>> 1;
        }
        return result;
    }
}
