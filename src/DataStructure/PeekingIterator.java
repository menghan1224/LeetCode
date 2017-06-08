package DataStructure;

import java.util.Iterator;

/**
 * Created by 28479 on 2017/6/8.
 */
public class PeekingIterator implements Iterator<Integer>{
    Integer peek = null;
    private Iterator<Integer> iterator;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }
    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(peek !=null) return peek;
        else {
            peek = iterator.next();
        }
        return peek;
    }
    @Override
    public Integer next() {
        if(peek != null) {
            int temp = peek;
            peek = null;
            return temp;
        }
        return iterator.next();
    }
    @Override
    public boolean hasNext() {
        if(peek != null) return true;
        else return iterator.hasNext();
    }
}
