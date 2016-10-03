public class Solution {
    class BIT {
	int n;
	int[] bit;

	BIT(int size) {
		this.n = size + 1;
		this.bit = new int[this.n];
	}

	void update(int i) {
		while (i <= n - 1) {
			bit[i]++;
			i = i + (i & -i);
		}
	}

	int sum(int i) {
		int ans = 0;
		while (i > 0) {
			ans += bit[i];
			i = i - (i & -i);
		}
		return ans;
	}
}

public List<Integer> countSmaller(int[] nums) {
	List<Integer> counts = new LinkedList<Integer>();

	if (nums == null || nums.length == 0)
		return counts;

	int[] orderedNums = nums.clone();
	Arrays.sort(orderedNums);
	int[] nums2 = IntStream.of(nums)
			.map(x -> Arrays.binarySearch(orderedNums, x) + 1).toArray();

	BIT bit = new BIT(nums2.length);
	for (int i = nums2.length - 1; i >= 0; i--) {
		counts.add(0, bit.sum(nums2[i]));
		bit.update(nums2[i] + 1);
	}

	return counts;
}
}