public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Set<Integer> firstVisited = new HashSet<>();
        Set<Integer> secondVisited = new HashSet<>();
        char[] map = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        
        int len = 10;
        for (int i = 0; i < s.length() - len + 1; i++) {
            int v = 0;
            for (int j = i; j < i + len; j++) {
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if (!firstVisited.add(v) && secondVisited.add(v))
                list.add(s.substring(i, i + len));
        }
        return list;
    }
}