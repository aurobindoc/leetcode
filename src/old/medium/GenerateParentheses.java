package old.medium;

import java.util.*;

/**
 * Created by aurobindo.m on 25/01/22
 * <p>
 * Problem: https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        HashSet<String> temp;
        map.put(0, new ArrayList<>());
        map.put(1, Collections.singletonList("()"));
        map.put(2, Arrays.asList("()()", "(())"));
        map.put(3, Arrays.asList("()()()", "(()())", "()(())", "((()))", "(())()"));

        for (int i = 4; i <= n; i++) {
            temp = new HashSet<>();
            for (int j = i - 1; j >= i / 2; j--) {
                for (String s : map.get(j)) {
                    for (String t : map.get(i - j)) {
                        if(i - j == 1) temp.add("(" + s + ")");
                        temp.add(t + s);
                        temp.add(s + t);
                    }
                }
            }
            map.put(i, new ArrayList<>(temp));
        }
        return map.get(n);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new GenerateParentheses().generateParenthesis(n));
    }
}