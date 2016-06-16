public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        char[] value = s.toCharArray();
        for(int i = 0; i < value.length; i++) {
            if('0' <= value[i] && value[i] <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if(value[i] == '.') {
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if(value[i] == 'e') {
                if(eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if(value[i]== '-' || value[i] == '+') {
                if(i != 0 && value[i - 1] != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
    
        return numberSeen && numberAfterE;
    }
}