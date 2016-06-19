public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        if (numRows == 0) {
            return results;
        }
        List<Integer> one = new ArrayList(){{
            add(1);
        }};
        results.add(one);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = results.get(i - 1);
            List<Integer> crt = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                crt.add((j < i ? prev.get(j) : 0) + (j > 0? prev.get(j - 1) : 0));
            }
            results.add(crt);
        }
        return results;
    }
}