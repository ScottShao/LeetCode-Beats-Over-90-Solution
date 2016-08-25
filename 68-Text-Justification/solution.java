public class Solution {
    public List<String> fullJustify(String[] words, int L) {
    List<String> list = new ArrayList<>();
    int strLen = 0; // length of all strings in a line with a single space in each interval
    int start = 0, end = 0;
    for (int i = 0; i < words.length; i++) {
            if (strLen == 0 || strLen + words[i].length() + 1<= L) { // add word if <= L chars
                if (strLen > 0) strLen += 1;
                strLen += words[i].length();
                end = i;
            } else { // form a line if > L chars
                list.add(formLine(words, start, end, strLen, L));
                strLen = words[i].length();
                start = i;
                end = i;
            }
        }
        list.add(formLine(words, start, end, strLen, L)); // form the last time
        return list;
    }

    private String formLine(String[] words, int start, int end, int strLen, int L) {
        int N = end - start; // number of intervals
        int M = L - strLen; // extra spaces
        StringBuilder str = new StringBuilder();
        if (N == 0 || end == words.length - 1) { // left-adjusted for one word or last line
            for (int i = start; i <= end; i++) {
                if (i > start)  str.append(" ");
                str.append(words[i]);
            }
            for (int i = 0; i < M; i++) str.append(" ");
        } else {
            for (int i = start; i <= end; i++) {
                if (i == start) str.append(words[i]);
                else {
                    for (int j = 0; j < 1 + M / N; j++) str.append(" "); // evenly distribute space
                    if (i <= start + M % N) str.append(" "); // add extra space from beginning
                    str.append(words[i]);
                }
            }
        }
        return str.toString();
    }
}