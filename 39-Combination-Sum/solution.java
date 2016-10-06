public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates.length == 0){
            return res;
        }
        compute(candidates, target, 0, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    public void compute(int[] candidates, int target, int sum, int start, List<Integer> list, List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<Integer>(list));
            return;
        }else if(sum > target){
            return;
        }else{
            for(int index = start; index < candidates.length; index++){
                if(sum + candidates[index] <= target){
                    list.add(candidates[index]);
                    sum = sum + candidates[index];
                    compute(candidates, target, sum, index, list, res);
                    list.remove(list.size() - 1);
                    sum = sum - candidates[index];
                }
            }
        }
    }
}