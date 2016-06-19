public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        if (numRows == 0) {
            return results;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> prev = i == 0 ? null : results.get(i - 1);
            List<Integer> crt = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    crt.add(1);
                } else {
                    crt.add(prev.get(j) + prev.get(j - 1));
                }
            }
            results.add(crt);
        }
        return results;
    }
}