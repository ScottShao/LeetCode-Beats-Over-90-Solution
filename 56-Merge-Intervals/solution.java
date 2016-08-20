/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        List<Interval> res = new ArrayList<>();
        int size = intervals.size();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < size; i++) {
            Interval crt = intervals.get(i);
            if (crt.start <= end) {
                end = Math.max(crt.end, end);
            } else {
                res.add(new Interval(start, end));
                start = crt.start;
                end = crt.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}