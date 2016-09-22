public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null) return 0;
        int len = citations.length;
        if (len == 0) return 0;
        int left = 0;
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (len - mid <= citations[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return len - left;
    }
}