public class Solution {
    public String countAndSay(int n) {
        StringBuilder prev = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder crt = new StringBuilder();
            char prevCh = prev.charAt(0);
            int count = 1;
            for (int j = 1; j < prev.length(); j++) {
                char ch = prev.charAt(j);
                if (ch == prevCh) {
                    count++;
                } else {
                    crt.append(count);
                    crt.append(prevCh);
                    count = 1;
                    prevCh = ch;
                }
            }
            crt.append(count);
            crt.append(prevCh);
            prev = crt;
        }
        return prev.toString();
    }
}