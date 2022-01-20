package hard;

/**
 * Created by aurobindo.m on 19/01/22
 * <p>
 * Problem: https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {


    public boolean isMatch(String s, String p) {

        int r = p.length(), c = s.length();
        if (!p.contains("*") && r !=c ) return false;

        boolean[][] dp = new boolean[r + 1][c + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= p.length(); i++) {
            for (int j = 1; j < c + 1; j++) {

                if (p.charAt(i - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (p.charAt(i - 1) != '*') {
                        dp[i][j] = dp[i - 1][j - 1] && p.charAt(i - 1) == s.charAt(j - 1);
                    } else {
                        if (p.charAt(i - 2) == '.') dp[i][j] = true;
                        else if (p.charAt(i - 2) == '*') return false;
                        else {
                            if (p.charAt(i - 2) == s.charAt(j - 1)) dp[i][j] = dp[i][j - 1];
                            else {
                                dp[i][j] = dp[i - 1][j] || dp[i - 2][j];
                            }
                        }
                    }
                }
            }
            System.out.println("=========== " + p.charAt(i - 1) + " ============");
            printArray(dp);
            System.out.println("==========================");
        }
        return dp[r][c];
    }

    private static void printArray(boolean[][] arr) {
        for (boolean[] booleans : arr) {
            for (boolean b : booleans) {
                System.out.print(b + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(new RegularExpressionMatching().isMatch(s, p));
    }

}
