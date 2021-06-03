package hot100.medium;

import java.util.*;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 * */

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        /**
         * 主要思路：
         * list存储不重复的子串序列，i指针遍历，j指针记录不重复的子串序列的第一个字符的索引。
         * 每次循环：
         *      当前字符不存在于list中，添加进去；
         *      当前字符存在于list中，把list中这个字符以及前边的字符删除，
         *          把j指针+cur_index（这个字符的索引），也就是把j指针移到目前最长字串在原字符串中的第一个字符的位置，
         *          把当前字符放入list中，
         *          把count置为list的长度。
         *      及时更新子串的最大长度。
         * */
        List<Character> list = new ArrayList<Character>();
        int n = s.length();
        int max_count = 0;
        int count = 0;
        int j = 0;
        for(int i = 0; i < n; i ++){
            char c = s.charAt(i);
            if(list.indexOf(new Character(c)) == -1){
                list.add(new Character(c));
                count ++;
            }
            else{
                j += list.indexOf(new Character(c)) + 1;
                list = list.subList(list.indexOf(new Character(c)) + 1,list.size());
                list.add(new Character(c));
            }
            count = list.size();
            if(count > max_count){
                max_count = count;
            }
        }
        return max_count;
    }
}
