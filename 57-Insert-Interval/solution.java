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
        if(intervals == null || newInterval == null){
            return new ArrayList<>(intervals);
        }
        List<Interval> result = new ArrayList<>();
        intervals.add(0, new Interval(Integer.MIN_VALUE, Integer.MIN_VALUE)); //Add for using when newInterval is the smallest interval
        intervals.add(new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE)); //Add for using when newInterval is the greatest interval
        int startIndex = binarySearch(intervals, newInterval.start, false);//Start compares to end
        int endIndex = binarySearch(intervals, newInterval.end, true);//End compares to start
        //Insert intervals smaller than newInterval
        for(int i = 1; i < startIndex; ++i){
            result.add(intervals.get(i));
        }
        //endIndex is the first Interval in intervals that has start greater than newInterval.end
        if(endIndex < intervals.size() && intervals.get(endIndex).start == newInterval.end){
            ++endIndex;
        }
        //Merge
        result.add(new Interval(Math.min(intervals.get(startIndex).start, newInterval.start), Math.max(intervals.get(endIndex - 1).end, newInterval.end)));
        //Insert intervals greater than newInterval
        for(int i = endIndex; i < intervals.size() - 1; ++i){
            result.add(intervals.get(i));
        }
        return result;
    }

    private int binarySearch(List<Interval> intervals, int val, boolean isStart){
        int low = 0;
        int high = intervals.size();
        while(low < high){
            int middle = low + (high - low) / 2;
            Interval interval = intervals.get(middle);
            int curVal = interval.end;
            if(isStart){
                curVal = interval.start;
            }
            if(val == curVal){
                return middle;
            }else if(val > curVal){
                low = middle + 1;
            }else{
                high = middle;
            }
        }
        return low;
    }
}