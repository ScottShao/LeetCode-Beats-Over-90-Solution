public class LRUCache {
    private static final float LOAD_FACTOR = 0.75f;
    private LinkedHashMap<Integer, Integer> cache;
    
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>((int)(capacity / LOAD_FACTOR) + 1, LOAD_FACTOR, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
			    	return size() > capacity;
			}
        };
    }
    
    public int get(int key) {
        Integer val = cache.get(key);
        if (val == null) {
            return -1;
        } else {
            return val;
        }
    }
    
    public void set(int key, int value) {
        cache.put(key, value);
    }
}