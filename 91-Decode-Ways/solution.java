public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        int pre = 26;
        int answer = 0;
        int first = 1;
        int second = 1;
        char[] chs = s.toCharArray();
        for(int i = chs.length - 1; i >= 0; i--){
            int digit = chs[i] - '0';
            answer = digit == 0 ? 0 : first + (digit * 10 + pre <= 26 ? second : 0);
            second = first; 
            first = answer; 
            pre = digit;
        }
        return answer;
    }
}