public class OrderedSuperArray extends SuperArray{
    
    public OrderedSuperArray(){
	super();
    }

    public OrderedSuperArray(int initialCap){
	super(initialCap);
    }
	
    private int findIndex(String str){
	int x = 0;
	for(int i = 0; i < size(); i++){
	    if (str.compareTo(get(i)) < 0){
		x = i;
		break;
	    }else{
		x = i + 1;
	    }
	}
	return x;
    }
    
    public boolean add(String str){
	super.add(findIndex(str), str);
	return true;
    }

    public OrderedSuperArray(String[] ary){
        super(ary.length);
	for(int i = 0; i < ary.length; i++){
	    if(ary[i] != null){
		super.add(findIndex(ary[i]), ary[i]);
	    }
	}
    }

    public void add(int index, String str){
	throw new UnsupportedOperationException();
    }

    public String set(int index, String str){
	throw new UnsupportedOperationException();
    }
}
