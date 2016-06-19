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
            crt.add(1);
            for (int j = 1; j < i; j++) {
                crt.add(prev.get(j) + prev.get(j - 1));
            }
            crt.add(1);
            results.add(crt);
        }
        return results;
    }
}