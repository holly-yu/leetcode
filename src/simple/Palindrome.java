package simple;

import java.util.Stack;

//判断一个整数是否是回文数回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
public class Palindrome {
    public static boolean isPalindrome(int x){
        if (x<0)
            return false;
        int num = x;
        int result = 0;
        int count = 1;
        Stack<Integer> s = new Stack<Integer>();
        do {
            s.push(num%10);
            num = (num-num%10) /10;
        }while (num!=0);
        while(!s.empty()){
            result += s.pop()*count;
            count *= 10;
        }
        return result==x;
    }

    public static boolean isPalindrome2(int x){
        if (x<0)
            return false;
        int result = 0;
        int rem = 0;
        int num = x;
        while(num!=0){
            rem = num % 10;
            result = result * 10 + rem;
            num = (num - rem) / 10;
        }

        return result==x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
