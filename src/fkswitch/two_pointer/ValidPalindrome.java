package fkswitch.two_pointer;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int b = 0;
        int e = s.length() - 1;
        while (b < e) {
            char start = s.charAt(b);
            if (!(start >= 'a' && start <= 'z') && !(start >= 'A' && start <= 'Z') && !(start >= '0' && start <= '9')) {
                b++;
                continue;
            }
            char end = s.charAt(e);
            if (!(end >= 'a' && end <= 'z') && !(end >= 'A' && end <= 'Z') && !(end >= '0' && end <= '9')) {
                e--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(b)) != Character.toLowerCase(s.charAt(e))) {
                return false;
            } else {
                b++;
                e--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // complete the main
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String s = "0P";
        System.out.println(validPalindrome.isPalindrome(s));
    }
}
