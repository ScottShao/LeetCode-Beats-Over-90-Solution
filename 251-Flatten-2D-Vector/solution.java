public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> outIter;
    private Iterator<Integer> inIter;
    
    public Vector2D(List<List<Integer>> vec2d) {
        outIter = vec2d.iterator();
    }

    @Override
    public Integer next() {
        return inIter.next();
    }

    @Override
    public boolean hasNext() {
        while ((inIter == null || !inIter.hasNext()) && outIter.hasNext()) {
            inIter = outIter.next().iterator();
        }
        return inIter != null && inIter.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */