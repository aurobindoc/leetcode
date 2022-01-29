package easy;

/**
 * Created by aurobindo.m on 30/01/22
 * <p>
 * Problem: https://leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle)) return 0;
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            if(haystack.substring(i, i + needle.length()).equals(needle))   return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println(new ImplementStrStr().strStr(haystack, needle));
    }
}
