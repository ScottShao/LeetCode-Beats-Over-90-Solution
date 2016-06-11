/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> nestedList;
    Iterator<NestedInteger> iter;
    NestedInteger curtElem;
    NestedIterator nestedIter;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        iter = nestedList.iterator();
    }
    
    
    @Override
    public Integer next() {
        if (curtElem.isInteger()){
            Integer item = curtElem.getInteger();
            curtElem = null;
            return item;
        } else{
            Integer item = nestedIter.next();
            if (!nestedIter.hasNext()){
                curtElem =  null;
            }
            return item;
        }
    }
    
    @Override
    public boolean hasNext() {
        // try to assign curtElem
        while (curtElem == null && iter.hasNext()){
            curtElem = iter.next();
            if (curtElem.isInteger()){
                //nestedIter = null;
                return true;
            } else{
                nestedIter = new NestedIterator(curtElem.getList());
                if (nestedIter.hasNext()){
                    return true;
                } else{
                    curtElem = null;
                }
            }
        }
    
        // no need to assign curtElem
        if (curtElem == null){
            return false;
        } else{
            return true; 
        }

    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */