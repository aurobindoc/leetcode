package old.medium;

import java.util.Arrays;

/**
 * Created by aurobindo.m on 17/01/22
 * <p>
 * Problem: https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        String[] res = new String[numRows];
        String result = "";
        Arrays.fill(res, "");
        int counter = 1;
        int bucket = 0;
        for (int i = 0; i < s.length(); i++) {
            res[bucket] += s.charAt(i);
            if (numRows == 1) continue;
            if (bucket + counter >= numRows) {
                counter = -1;
            } else if (bucket + counter < 0) {
                counter = 1;
            }
            bucket += counter;
        }
        for (String r : res) {
            result += r;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "AB";
        int rows = 1;
        System.out.println(new ZigzagConversion().convert(s, rows));
    }
}
