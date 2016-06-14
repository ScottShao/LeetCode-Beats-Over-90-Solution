public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null) {
            return results;
        }
        char[] value = s.toCharArray();
        int len = value.length;
        boolean[][] p = new boolean[len][len];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len - i; j++)
                p[j][j + i] = value[j] == value[j + i] && (i <= 1 || p[j + 1][j + i - 1]);
        search(s.toCharArray(), 0, new ArrayList<String>(), results, new HashMap<Integer, Set<Integer>>(), p);
        return results;
    }
    
    private void search(char[] value, int start, List<String> crt, List<List<String>> results, Map<Integer, Set<Integer>> memo, boolean[][] p) {
        if (start == value.length) {
            List<String> temp = new ArrayList<>(crt);
            results.add(temp);
        } else {
            Set<Integer> set = memo.get(start);
            int len = crt.size();
            if (set != null) {
                for (int idx : set) {
                    crt.add(new String(value, start, idx - start));
                    search(value, idx, crt, results, memo, p);
                    crt.remove(len);
                }
            } else {
                set = new HashSet<>();
                for (int j = start; j < value.length; j++) {
                    if (p[start][j]) {
                        set.add(j + 1);
                        crt.add(new String(value, start, j - start + 1));
                        search(value, j + 1, crt, results, memo, p);
                        crt.remove(len);
                    }
                }
                memo.put(start, set);
            }
        }
    }
}