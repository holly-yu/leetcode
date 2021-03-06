package simple;

/**
 * 13. 罗马数字转整数
 *
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 *
 * 
 *
 * 示例1:
 * 输入:"III"
 * 输出: 3
 *
 * 示例2:
 * 输入:"IV"
 * 输出: 4
 *
 * 示例3:
 * 输入:"IX"
 * 输出: 9
 *
 * 示例4:
 * 输入:"LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * 示例5:
 * 输入:"MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 提示：
 *
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 * */

public class RomanToInt {
    /**
     * 对每一位字符相应转整数。
     * 关键就在于要对三种特例情况进行处理。
     * 时间复杂度为O(n),空间复杂度为O(1).
     * */
    public int romanToInt(String s) {
        int n = s.length();
        int i = 0, res = 0;
        while( i < n){
            if(s.charAt(i) == 'I'){
                if( i + 1 < n &&  s.charAt(i+1) == 'V'){
                    res += 4;
                    i +=2;
                }
                else if(i + 1 < n && s.charAt(i+1) == 'X'){
                    res += 9;
                    i +=2;
                }
                else{
                    res += 1;
                    i++;
                }
            }
            else if(s.charAt(i) == 'X'){
                if( i + 1 < n &&  s.charAt(i+1) == 'L'){
                    res += 40;
                    i +=2;
                }
                else if(i + 1 < n && s.charAt(i+1) == 'C'){
                    res += 90;
                    i +=2;
                }
                else{
                    res += 10;
                    i++;
                }
            }
            else if(s.charAt(i) == 'C'){
                if( i + 1 < n &&  s.charAt(i+1) == 'D'){
                    res += 400;
                    i +=2;
                }
                else if(i + 1 < n && s.charAt(i+1) == 'M'){
                    res += 900;
                    i +=2;
                }
                else{
                    res += 100;
                    i++;
                }
            }
            else if(s.charAt(i) == 'V'){
                res += 5;
                i ++;
            }
            else if(s.charAt(i) == 'L'){
                res += 50;
                i ++;
            }
            else if(s.charAt(i) == 'D'){
                res += 500;
                i ++;
            }
            else{
                res += 1000;
                i ++;
            }
        }
        return res;
    }

    /**
     * 官方题解的方法更简便一些，避免逻辑过于复杂。
     * 思路：如果当前位代表的书比后一位小，则说明是三种特殊情况，其实就是相当于最后总数 - 当前位代表的数（例如：IV = 4 = -1 + 5）;
     *      否则则 为＋。
     * */
    public int romanToInt2(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}
