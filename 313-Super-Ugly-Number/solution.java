public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pointer = new int[primes.length];
        int ugly[] = new int[n];
        ugly[0] = 1;
        for(int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 0; j < primes.length; j++){
                int temp = ugly[pointer[j]] * primes[j];
                if(temp < min){
                    min = temp;
                    minIndex = j;
                }else if(temp == min){
                    pointer[j]++;
                }
            }
            ugly[i] = min;
            pointer[minIndex]++;
        }
        return ugly[n - 1];
    }
}