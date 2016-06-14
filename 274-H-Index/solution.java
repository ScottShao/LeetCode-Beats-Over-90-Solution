public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int i = 0;
        while (i < citations.length && citations[i] < citations.length - i) i++;
        return citations.length - i;
    }
}