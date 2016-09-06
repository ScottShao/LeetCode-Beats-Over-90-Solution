/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        Map<Integer, Map<Integer, int[]>> pointsCount = new HashMap<>();
        int len = points.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int overlap = 0;
            int temp = 0;
            pointsCount.clear();
            for (int j = i + 1; j < len; j++) {
                int xDif = points[i].x - points[j].x;
                int yDif = points[i].y - points[j].y;
                if (xDif == 0 && yDif == 0) {
                    overlap++;
                } else {
                    int gcd = gcd(xDif, yDif);
                    if (gcd != 0) {
                        xDif /= gcd;
                        yDif /= gcd;
                    }
                    Map<Integer, int[]> map = pointsCount.get(xDif);
                    if (map == null) {
                        map = new HashMap();
                        pointsCount.put(xDif, map);
                    }
                    int[] c = map.get(yDif);
                    if (c == null) {
                        c = new int[1];
                        map.put(yDif, c);
                    }
                    c[0]++;
                    temp = Math.max(temp, c[0]);
                }
            }
            max = Math.max(temp + overlap + 1, max);
        }
        return max;
    }
    
    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}