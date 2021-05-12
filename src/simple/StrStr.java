package simple;

/**
 * 28. 实现 strStr()
 *
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 *  
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 *
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 *
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 *  
 * 提示：
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成.
 * */
public class StrStr {
    /**
     * 暴力匹配：
     * 时间复杂度：O(n×m)，空间复杂度：O(1)。
     * */
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length(), n2 = needle.length();
        int res = -1;
        if(n2 == 0){    // (needle == "") 做判断条件不对, 但自己在java环境中测试String s = ""; System.out.println(s==""); 结果为True.
            return 0;
        }
        if(n1 < n2){
            return -1;
        }
        for(int i = 0; i < n1; i ++){
            if(n1 - i < n2){
                return -1;
            }
            int j = 0;
            for( j = 0; j < n2; j ++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }

            }
            if(j == n2){
                res = i;
                break;
            }
        }

        return res;
    }

    /**
     * KMP算法
     * 未完待续。。。
     *
     *
     * 时间复杂度：O(n+m)，空间复杂度：O(m)。
     * */
}
