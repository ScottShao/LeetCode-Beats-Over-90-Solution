public class Solution {
    public String getPermutation(int n, int k) {
         StringBuilder num = new StringBuilder(); // "12..n"
        int[] factorial = new int[n + 1]; // stores 0!, 1!,..., n!
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            num.append(i);
            factorial[i] = factorial[i - 1] * i;
        }
        
        k--;    // start from base 0!!
        
        StringBuilder str = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            int index = k / factorial[i - 1];
            str.append(num.charAt(index));
            num.deleteCharAt(index);
            k = k % factorial[i - 1];
        }
        return str.toString();
    }
}