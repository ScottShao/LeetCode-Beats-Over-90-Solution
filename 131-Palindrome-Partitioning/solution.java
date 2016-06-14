public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null) {
            return results;
        }
        search(s.toCharArray(), 0, new ArrayList<String>(), results, new HashMap<Integer, Set<Integer>>());
        return results;
    }
    
    private void search(char[] value, int start, List<String> crt, List<List<String>> results, Map<Integer, Set<Integer>> memo) {
        if (start == value.length) {
            List<String> temp = new ArrayList<>(crt);
            results.add(temp);
        } else {
            Set<Integer> set = memo.get(start);
            int len = crt.size();
            if (set != null) {
                for (int idx : set) {
                    crt.add(new String(value, start, idx - start));
                    search(value, idx, crt, results, memo);
                    crt.remove(len);
                }
            } else {
                set = new HashSet<>();
                for (int j = start; j < value.length; j++) {
                    if (isPalindrome(value, start, j)) {
                        set.add(j + 1);
                        crt.add(new String(value, start, j - start + 1));
                        search(value, j + 1, crt, results, memo);
                        crt.remove(len);
                    }
                }
                memo.put(start, set);
            }
        }
    }
    
    private boolean isPalindrome(char[] value, int i, int j) {
        while (i < j) {
            if (value[i++] != value[j--]) {
                return false;
            }
        }
        return true;
    }
}