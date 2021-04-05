package 剑指Offer;

import java.util.Scanner;

public class ReplaceSpace {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(replaceSpace(s));


    }

    public static String replaceSpace(String s) {
        char strings[] = s.toCharArray();
        if (strings.length==0){
            return s.replace(" ","%20");
        }
        String result = "";
        for (int i = 0; i < strings.length - 1; i++) {
            result+=strings[i];
            result+="%20";
        }
        result+=strings[strings.length-1];
        return result;
    }

    public static String replaceSpace2(String s) {
        return s.replace(" ","%20");
    }

    //比较正确解法
    public static String replaceSpace3(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c==' '){
                result+="%20";
            }
            else
                result+=c;
        }
        return result;
    }
}
