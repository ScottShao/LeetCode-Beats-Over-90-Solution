public class Solution {
    public int[] countBits(int num) {
        int[] re = new int[num + 1];
        for (int i = 1, up = 2; i <= num; i *= 2, up *= 2) {
            for (int j = i, m = 0; j < up && j <= num; j++, m++) {
                re[j] = re[m] + 1;
            }
        }
        return re;
    }
}