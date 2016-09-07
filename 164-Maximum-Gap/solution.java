public class Solution {
    public int maximumGap(int[] num) {
        if (num == null || num.length < 2)
            return 0;
        int numOfDigit = 10;
        int len = num.length;
        
        int[] aux = new int[len];
        int max = num[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(num[i], max);
        }
        int exp = 1;
        while (max / exp > 0) {
            int[] count = new int[numOfDigit];
            for (int n : num) {
                count[n / exp % numOfDigit]++;
            }
            
            for (int i = 1; i < numOfDigit; i++) {
                count[i] += count[i - 1];
            }
            
            for (int i = len - 1; i >= 0; i--) {
                aux[--count[num[i] / exp % numOfDigit]] = num[i];
            }
            
            for (int i = 0; i < len; i++) {
                num[i] = aux[i];
            }
            exp *= 10;
        }
        int maxGap = 0;
        for (int i = 1; i < len; i++) {
            maxGap = Math.max(maxGap, num[i] - num[i - 1]);
        }
        return maxGap;
    }
}