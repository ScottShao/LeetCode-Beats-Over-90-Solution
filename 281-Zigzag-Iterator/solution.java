public class ZigzagIterator {
    private Iterator<Integer> crt;
    private Iterator<Integer> first;
    private Iterator<Integer> second;
    private boolean usingFirst;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if (v1 != null) {
            first = v1.iterator();
        }
        if (v2 != null) {
            second = v2.iterator();
        }
        if (first == null) {
            first = second;
        }
        if (second == null) {
            second = first;
        }
        crt = first;
        usingFirst = true;
    }

    public int next() {
        int re = crt.next();
        if (usingFirst) {
            crt = second;
        } else {
            crt = first;
        }
        usingFirst = !usingFirst;
        return re;
    }

    public boolean hasNext() {
        if (crt == null) return false;
        boolean re = crt.hasNext();
        if (!re) {
            if (usingFirst) first = second;
            else second = first;
            crt = first;
        }
        return crt.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */