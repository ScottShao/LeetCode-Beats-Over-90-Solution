public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        int length = pattern.length();
        if(strs.length != length) return false;
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(Integer i = 0;i<length;i++){
            if(map.put(pattern.charAt(i)+"*",i) != map.put(strs[i],i)){
                return false;
            }
        }
        return true;
    }
}