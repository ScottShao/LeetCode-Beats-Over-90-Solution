public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if (n <= 0) {
            return res;
        }
        int crt = 0;
        int next = 1;
        for (int i = 1; i <= n; i++) {
            crt = next;
            next <<= 1;
            for (int j = crt - 1; j >= 0; j--) {
                res.add(crt ^ res.get(j));
            }
        }
        return res;
    }
}