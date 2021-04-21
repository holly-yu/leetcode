package hot100.simple;

/**
 * 66. 加一
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  
 *
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 *  
 *
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * */

public class PlusOne {
    /**
     * 最开始想的很简单，就是把数组挨个数字计算然后变为 整数 ，然后+1再求各位数字放在数组中。
     * 想法很天真，实际上数组长度可以到达100，远远超过计算机能表达的最大整数范围，因此不行。
     *
     * 最后方法就是 先遍历一遍确定下结果数组长度，如果所有位都为9（如：9999），结果数组会比输入数组长度大1，结果也就是（10000）。
     * 如果不是这种情况，就在原数组上操作即可，设置count记录是否需要进位，需要为1（初始为1），不需要为0。然后从尾到头各位数依次+1，如果==10，就该数位设置为0，count设为1。
     *
     * */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int res = 0,n2; //n2是结果数组的长度
        int[] plus;
        boolean flag = true;
        for(int i = 0; i < n; i ++){
            if(digits[i] != 9){
                flag = false;
            }
        }

        if(flag){
            n2 = n + 1;
            plus = new int[n2];
            plus[0]=1;
        }
        else{
            n2 = n;
            plus = new int[n2];
            int count = 1;
            for(int i = n2 - 1; i >= 0; i --){
                if(digits[i] + count == 10){
                    plus[i] = 0;
                    count = 1;
                }
                else{
                    plus[i] = digits[i] + count;
                    count = 0;
                }
            }
        }
        return plus;
    }

    // 非常巧的办法
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;  // 如果为10，则返回0，否则返回本身
            if (digits[i] != 0) return digits;  // 如果不需要进位，则前边的数就不需要继续计算了。
        }
        digits = new int[digits.length + 1];    // 循环进行完说明每个数位都是9
        digits[0] = 1;
        return digits;
    }

}
