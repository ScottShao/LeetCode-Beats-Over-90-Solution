public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            gas[i] -= cost[i];
            sum += gas[i];
        }
        if (sum < 0) {
            return -1;
        }
        int start = 0;
        while (true) {
            while (gas[start] < 0) start = (start + 1) % len;
            sum = gas[start];
            int crt = (start + 1) % len;
            while (sum >= 0 && crt != start) {
                sum += gas[crt];
                crt = (crt + 1) % len;
            }
            if (crt != start) {
                start = crt;
            } else {
                return start;
            }
        }
    }
}