public class Solution {
    public int hIndex(int[] citations) {
       if(citations == null)   return 0;
        int[] buffer = new int[citations.length+1];
    
        for(int num : citations) {
            int idx = Math.min(num, citations.length);
            buffer[idx]++;
        }
    
        int sum = 0;
        for(int i = buffer.length -1 ; i >= 0 ; i--) {
            sum += buffer[i];
            if(sum >= i) return i;
        }
    
        return 0;
    }
}