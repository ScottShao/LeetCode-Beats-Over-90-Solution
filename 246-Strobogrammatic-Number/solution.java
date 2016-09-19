public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null) return false;
        char[] vals = num.toCharArray();
        int left = 0, right = vals.length - 1;
        while (left < right) {
            if ((vals[left] == '6' && vals[right] == '9') || (vals[left] == '9' && vals[right] == '6') || (vals[left] == '8' && vals[right] == '8') || (vals[left] == '1' && vals[right] == '1') || (vals[left] == '0' && vals[right] == '0')) {
                left++;
                right--;
                continue;
            } else {
                return false;
            }
            
        }
        return left == right ? vals[left] == '8' || vals[left] == '1' || vals[left] == '0': true;
    }
}