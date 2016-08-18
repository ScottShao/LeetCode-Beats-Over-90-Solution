public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> crt = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return crt;
        }
        crt.add(new ArrayList<>());
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            List<List<Integer>> next = new ArrayList<>();
            for (List<Integer> onePerm : crt) {
                for (int j = 0; j <= i; j++) {
                    List<Integer> temp = new ArrayList<>(onePerm);
                    temp.add(j, nums[i]);
                    next.add(temp);
                }
            }
            crt = next;
        }
        return crt;
    }
}