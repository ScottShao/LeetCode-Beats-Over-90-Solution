public class TwoSum {
    private Map<Integer, int[]> map;
    
    public TwoSum() {
        map = new HashMap<>();
    }
    // Add the number to an internal data structure.
	public void add(int number) {
	    int[] count = map.get(number);
	    if (count == null) {
	        count = new int[1];
	        map.put(number, count);
	    }
	    count[0]++;
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (Map.Entry<Integer, int[]> en : map.entrySet()) {
	        int target = value - en.getKey();
	        int[] count = map.get(target);
	        if (count != null) {
	            if (target == en.getKey() && count[0] > 1) return true;
	            else if (target != en.getKey()) return true;
	        }
	    }
	    return false;
	}
	
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);