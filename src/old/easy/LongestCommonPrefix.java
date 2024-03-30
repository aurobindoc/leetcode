package old.easy;

/**
 * Created by aurobindo.m on 22/01/22
 * <p>
 * Problem: https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int l = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            l = Math.min(l, strs[i].length());
        }
        char c;
        String lcp = "";
        boolean flag;
        for (int j = 0; j < l; j++) {
            flag = true;
            c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                flag = flag && c == strs[i].charAt(j);
            }
            if (flag)
                lcp += c;
            else break;
        }
        return lcp;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "p"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
