public class Solution {
    public int numSquares(int n) {
        if(n==0) return 0;
        for(int i=0; i*i<=n; i++){
            int j=(int)Math.sqrt(n-i*i);
            if(i*i+j*j==n){
               if(i==0||j==0) return 1;
               else return 2;
            } 
        }
        while(n%4==0) n /= 4;
        if(n%8==7) return 4;
        return 3;
    }
}