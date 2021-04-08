package hot100.simple;

/*
20. 有效的括号

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
 */

import java.util.Scanner;
import java.util.Stack;

public class brackets {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(isValid(input.next()));
    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else{
                if (stack.isEmpty()){
                    return false;
                }
                else {
                    if (c==')'){
                        if(stack.lastElement() !='('){
                            return false;
                        }
                        else
                            stack.pop();
                    }
                    if (c==']'){
                        if(stack.lastElement() !='['){
                            return false;
                        }
                        else
                            stack.pop();
                    }
                    if (c=='}'){
                        if(stack.lastElement() !='{'){
                            return false;
                        }
                        else
                            stack.pop();
                    }
                }

            }

        }
        if(!stack.isEmpty()){
            return false;
        }
        else
            return true;
    }
}

