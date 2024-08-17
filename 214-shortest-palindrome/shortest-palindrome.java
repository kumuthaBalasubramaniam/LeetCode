class Solution {

    public static String shortestPalindrome(String s) {
        // Reverse the given string
        String rev = new StringBuilder(s).reverse().toString();

        // Combine the original string with its reverse
        String combined = s + "#" + rev;

        // Compute the prefix array for the combined string
        int[] prefix = computePrefix(combined);

        // The value at the last index of the prefix array tells us
//the length of the
        // longest palindrome prefix of the original string.
        int palindromeLength = prefix[prefix.length - 1];

        // Append the non-palindromic suffix from the reverse to the
//front of the original string
        return rev.substring(0, s.length() - palindromeLength) + s;
    }

    // Helper method to compute the prefix array (KMP algorithm)
    private static int[] computePrefix(String s) {
        int[] prefix = new int[s.length()];
        int j = 0;

        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = prefix[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            prefix[i] = j;
        }
        return prefix;
    }


}
