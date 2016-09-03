public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int prev = 0, total = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            prev += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (prev < 0) {
                prev = 0;
                start = i + 1;
            }
        }
        if (total < 0)  return -1;
        else            return start;
    }
}