public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] vals = s.toCharArray();
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(vals[i]))  i++;
            while (i < j && !Character.isLetterOrDigit(vals[j]))  j--;
            if (Character.toLowerCase(vals[i]) != Character.toLowerCase(vals[j]))
                return false;
            i++; j--;
        }
        return true;
    }
}