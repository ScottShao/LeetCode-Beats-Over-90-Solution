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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> results = new ArrayList<>();
        int newStart = newInterval.start;
        int newEnd = newInterval.end;
        int idx = 0;
        for (; idx < intervals.size(); idx++) {
            Interval temp = intervals.get(idx);
            if (temp.end >= newStart) {
                newStart = Math.min(temp.start, newStart);
                break;    
            } else {
                results.add(temp);
            }
        }
        for (; idx < intervals.size(); idx++) {
            Interval temp = intervals.get(idx);
            if (temp.start > newEnd) {
                break;    
            } else {
                newEnd = Math.max(temp.end, newEnd);
            }
        }
        results.add(new Interval(newStart, newEnd));
        
        while (idx < intervals.size()) {
            results.add(intervals.get(idx));
            idx++;
        }
        
        return results;
    }
}