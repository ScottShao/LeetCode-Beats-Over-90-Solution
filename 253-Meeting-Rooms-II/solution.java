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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null) return 0;
        int len = intervals.length;
        int count = 0;
         Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }        
        });
        List<Interval> crt = Arrays.asList(intervals);
        while ((len = crt.size()) > 0) {
            Interval prev = crt.get(0);
            List<Interval> next = new ArrayList<>();
            for (int i = 1; i < len; i++) {
                Interval temp = crt.get(i);
                if (prev.end > temp.start) next.add(temp);
                else prev = temp;
            }
            count++;
            crt = next;
        }
        return count;
    }
}