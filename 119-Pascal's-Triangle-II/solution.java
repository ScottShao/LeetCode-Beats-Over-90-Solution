public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> results = new ArrayList<>(rowIndex + 1);
        int prev = 1;
        for (int i = 0; i <= rowIndex; i++) {
            prev = 1;
            for (int j = 0; j <= i; j++) {
                if (j == i) {
                    results.add(1);
                } else if (j == 0) {
                    results.set(j, 1);
                } else {
                    int temp = results.get(j);
                    results.set(j, results.get(j) + prev);
                    prev = temp;
                }
            }
        }
        return results;
    }
}