public class Solution {
    public void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n;
    if (k < n - k)  rotateRight(nums, k);
    else            rotateLeft(nums, n - k);
}

public void rotateRight(int[] nums, int k) {
    int n = nums.length;
    for (int i = 0; i < gcd(n, k); i++) { // there're gcd(n,k) elements in each block
        int last = nums[n - 1 - i];
        int j = n - 1 - i;
        while (true) {
            int l = j - k;
            if (l < 0) l += n;
            if (l == n - 1 - i) break;
            nums[j] = nums[l];
            j = l;
        }
        nums[j] = last;
    }
}

public void rotateLeft(int[] nums, int k) {
    int n = nums.length;
    for (int i = 0; i < gcd(n, k); i++) {
        int first = nums[i];
        int j = i;
        while (true) {
            int l = j + k;
            if (l >= n) l -= n;
            if (l == i) break;
            nums[j] = nums[l];
            j = l;
        }
        nums[j] = first;
    }
}

// greatest common divisor
private int gcd(int n, int k) {
    if (k == 0) return n;
    else        return gcd(k, n % k);
}
}