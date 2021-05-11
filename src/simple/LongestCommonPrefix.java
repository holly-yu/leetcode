package simple;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * */

public class LongestCommonPrefix {
    /**
     * 暴力解法：依次比较每个字符串的各位字符
     * 时间复杂度：O(mn)，空间复杂度：O(1)。
     * */
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int comLen = 0;
        if( n == 1){    // 字符串数组长度为1时，直接返回该字符串。
            return strs[0];
        }
        for(int i = 0; i < strs[0].length(); i ++){
            char c = strs[0].charAt(i);
            int flag = 0;
            for(int j = 1; j < n; j ++){
                if(strs[j].length() < i + 1){   // 要注意字符串越界问题，需要做一下检查。
                    flag = 0;
                    break;
                }
                else{
                    if(strs[j].charAt(i) == c){
                        flag = 1;
                    }
                    else{
                        flag = 0;
                        break;
                    }
                }
            }

            if(flag == 0){
                break;
            }
            else{
                comLen ++;
            }
        }

        return strs[0].substring(0,comLen);
    }
}
