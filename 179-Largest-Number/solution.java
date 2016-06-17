public class Solution {
    class NumWrapper {
        int num;
        long scale;
        public NumWrapper(int num) {
            scale = 1;
            this.num = num;
            int temp = num;
            do {
                temp /= 10;
                scale *= 10;
            } while (temp != 0);
        }
    }
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        NumWrapper[] wrappers = new NumWrapper[nums.length];
        for (int i = 0; i < nums.length; i++) {
            wrappers[i] = new NumWrapper(nums[i]);
        }
        
        Arrays.sort(wrappers, new Comparator<NumWrapper>() {
            @Override
            public int compare(NumWrapper nw1, NumWrapper nw2) {
                long n1 = nw1.num * nw2.scale + nw2.num;
                long n2 = nw2.num * nw1.scale + nw1.num;
                if (n2 > n1) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        if (wrappers[0].num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (NumWrapper nw : wrappers) {
            sb.append(nw.num);
        }
        return sb.toString();
    }
}