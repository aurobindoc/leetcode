package easy;

import java.util.HashMap;

/**
 * Created by aurobindo.m on 20/01/22
 * <p>
 * Problem: https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<Integer, String>() {{
            put(1000, "M");
            put(500, "D");
            put(100, "C");
            put(50, "L");
            put(10, "X");
            put(5, "V");
            put(1, "I");
        }};

        int c;
        String rom = "";
        int div = 1000;
        while (num > 0) {
            c = num / div;
            if (c == 9) {
                rom += map.get(div) + map.get(div * 10);
                c -= 9;
            } else if (c >= 5) {
                rom += map.get(div * 5);
                c -= 5;
            } else if (c == 4) {
                rom += map.get(div) + map.get(div * 5);
                c -= 4;
            }

            while (c-- > 0) {
                rom += map.get(div);
            }
            num %= div;
            div /= 10;
        }

        return rom;
    }

    public static void main(String[] args) {
        int num = 1993;
        System.out.println(new IntegerToRoman().intToRoman(num));
    }
}
