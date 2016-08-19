public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] vals = str.toCharArray();
            Arrays.sort(vals);
            String key = new String(vals);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(str);
        }
        for (Map.Entry<String, List<String>> en : map.entrySet()) {
            res.add(en.getValue());
        }
        return res;
    }
}