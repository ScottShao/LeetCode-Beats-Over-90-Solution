/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    private static final int L = 4;
    private char[] nBuf = new char[L];
    private int index = 4;
    private int bound = 4;
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int tmp = 0;
        int ans = 0;
        while (index < bound && ans < n) {
            buf[ans++] = nBuf[index++];
        }
        if (ans == n) return n;
        while((tmp = read4(nBuf)) != 0) {
            for(int i = 0;i < tmp;i++)
            {
                if(ans == n) {
                    index = i;
                    bound = tmp;
                    return ans;
                }
                buf[ans++] = nBuf[i];
            }
        }
        return ans;
    }
}