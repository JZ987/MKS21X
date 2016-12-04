import java.util.*;


public class SuperArrayIterator implements Iterator<String> {

    private int element;
    private SuperArray superArray;
    
    public SuperArrayIterator(SuperArray superAry){
	superArray = superAry;
	element = 0;
    }

    public boolean hasNext(){
	return element < superArray.size();
    }
    
    public String next(){
	if (hasNext()){
	    element++;
	    return superArray.get(element - 1);
	}
        else {
	    throw new NoSuchElementException();
	}
    }
        
    public void remove(){
	throw new UnsupportedOperationException();
    }
}
