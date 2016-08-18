public class Solution {
    private List<List<Integer>> listSet;
    private List<Integer> list;
    private Set<Integer> visited;
    
    public List<List<Integer>> permuteUnique(int[] num) {
        listSet = new ArrayList<List<Integer>>();
        list = new ArrayList<Integer>();
        visited = new HashSet<>();
        
        Arrays.sort(num);   // Need to sort!!
        dfs(num);
        return listSet;
    }
    
    private void dfs(int[] num) {
        if (list.size() == num.length) {
            /** if (!listSet.contains(list)) **/    // No need to check duplicate lists!!    
                listSet.add(new ArrayList<Integer>(list));
        } else {
            for (int i = 0; i < num.length; i++) {
                if (i > 0 && !visited.contains(i - 1) && num[i - 1] == num[i]) continue;    // skip the duplicated elements (important pruning step to increase speed)!!
                if (!visited.contains(i)) {
                    list.add(num[i]);
                    visited.add(i);
                    dfs(num);
                    list.remove(list.size() - 1);
                    visited.remove(i);
                }
            }
        }
    }
}