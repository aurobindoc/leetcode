package old.medium;

/**
 * Created by aurobindo.m on 18/01/22
 *
 * Problem: https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {
    public int myAtoi(String s) {
        int res = 0;
        boolean flag = false;

        int i = 0;
        char c;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i<s.length()) c = s.charAt(i);
        else return res;
        if (c == '-') {
            flag = true;
            i++;
        } else if (c == '+') {
            i++;
        }

        for (; i < s.length(); i++) {
            c = s.charAt(i);
            if (c - '0' > 9 || c - '0' < 0) {
                break;
            }
            int d = (c - '0');
            res = res * 10 + d;
            if (res < 0 || res % 10 != d) {
                return flag? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
        }
        return flag ? res * -1 : res;
    }


    public static void main(String[] args) {
        String s = "-21474836460";
        System.out.println(new StringToInteger().myAtoi(s));
    }

}
