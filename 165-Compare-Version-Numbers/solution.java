public class Solution {
    public int compareVersion(String version1, String version2) {
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();
        return compareVersion(v1, v2, 0, 0);
    }
    
    private int compareVersion(char[] v1, char[] v2, int i, int j) {
        int i1 = 0;
        while(i < v1.length && v1[i] != '.') {
            i1 = i1 * 10 + v1[i] - '0';
            i++;
        }
        int i2 = 0;
        while(j < v2.length && v2[j] != '.') {
            i2 = i2 * 10 + v2[j] - '0';
            j++;
        }
        if (i1 > i2) {
            return 1;
        } else if (i1 < i2) {
            return -1;
        } else {
            if (i >= v1.length && j >= v2.length) {
                return 0;
            }
            return compareVersion(v1, v2, i + 1, j + 1);
        }
    }
}