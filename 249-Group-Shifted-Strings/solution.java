public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            char[] vals = str.toCharArray();
            int dif = vals[0] - 'a';
            for (int i = 0; i < vals.length; i++) {
                vals[i] = (char) (vals[i] - dif);
                if (vals[i] < 'a') {
                    vals[i] = (char) (vals[i] + 26);
                }
            }
            String key = new String(vals);
            List<String> value = map.get(key);
            if (value == null) {
                value = new ArrayList<>();
                map.put(key, value);
            }
            value.add(str);
        }
        for (Map.Entry<String, List<String>> en : map.entrySet()) {
            res.add(en.getValue());
        }
        return res;
    }
}