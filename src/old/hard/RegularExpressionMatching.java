package old.hard;

/**
 * Created by aurobindo.m on 19/01/22
 * <p>
 * Problem: https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {


    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){

                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = false;
                }else if(j == 0){
                    if(p.charAt(i - 1) == '*'){
                        dp[i][j] = dp[i-2][j];
                    }else{
                        dp[i][j] = false;
                    }
                }else{

                    if(p.charAt(i - 1) == '.' || p.charAt(i-1) == s.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else if(p.charAt(i - 1) == '*'){
                        dp[i][j] = dp[i-2][j];
                        if(p.charAt(i-2) == s.charAt(j-1) || p.charAt(i-2) == '.'){
                            dp[i][j] = dp[i][j] || dp[i][j-1];
                        }
                    }else{
                        dp[i][j] = false;
                    }
                }

            }
        }
        return dp[p.length()][s.length()];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(new RegularExpressionMatching().isMatch(s, p));
    }

}
