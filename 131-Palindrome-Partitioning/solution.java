public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null) {
            return results;
        }
        char[] value = s.toCharArray();
        int len = value.length;
        boolean[][] p = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                p[j][j + i] = value[j] == value[j + i] && (i <= 1 || p[j + 1][j + i - 1]);
            }
        }
        search(s.toCharArray(), 0, new ArrayList<String>(), results, p);
        return results;
    }
    
    private void search(char[] value, int start, List<String> crt, List<List<String>> results, boolean[][] p) {
        if (start == value.length) {
            List<String> temp = new ArrayList<>(crt);
            results.add(temp);
        } else {
            int len = crt.size();
            for (int j = start; j < value.length; j++) {
                if (p[start][j]) {
                    crt.add(new String(value, start, j - start + 1));
                    search(value, j + 1, crt, results, p);
                    crt.remove(len);
                }
            }
        }
    }
}