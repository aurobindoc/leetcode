package easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by aurobindo.m on 25/01/22
 */
public class ValidParentheses {
    private static HashMap<Character, Character> map = new HashMap<Character, Character>() {{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('$');
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = stack.peek();
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == c) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.peek() == '$';
    }

    public static void main(String[] args) {
        String s = "[({})]";
        System.out.println(new ValidParentheses().isValid(s));
    }
}
