package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubstring("jfgjanakfs"));
    }

    private static int longestPalindromeSubstring(String s) {

        if (s == null || s.length() < 1)
            return 0;

        if (s.length() == 1)
            return 1;

        String maxPalindrome = "";

        for (int i = 1; i < s.length(); i++) {
            String oddPalindrome = expandPalindrome(s, i, i);
            String evenPalindrome = expandPalindrome(s, i - 1, i);

            if (oddPalindrome.length() > maxPalindrome.length())
                maxPalindrome = oddPalindrome;
            if (evenPalindrome.length() > maxPalindrome.length())
                maxPalindrome = evenPalindrome;
        }

        return maxPalindrome.length();
    }

    private static String expandPalindrome(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}