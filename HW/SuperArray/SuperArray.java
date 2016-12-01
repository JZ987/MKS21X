public class SuperArray{

    private int size;
    private String[] data;

    public SuperArray(){
	data = new String[10];
	size = 0;
    }

    public SuperArray(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException("Capacity cannot be negative");
	}
	data = new String[initialCapacity];
	size = 0;
    }

    public int size(){
	return size;
    }

    public boolean add(String n){
	if(size < data.length){
	    data[size] = n;
	    size ++;
	}else{
	    grow();
	    add(n);
	}
	return true;
    }

    public String get(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException("Index cannot be negative or greater than size");
	}
	return data[index];
    }

    private void grow(){
	String[] temp = new String[data.length * 2];

	for(int i = 0; i < size; i++){
	    temp[i] = data[i];
	}

	data = temp;
    }

    public void clear(){
	size = 0;
    }

    public boolean isEmpty(){
	return size == 0;
    }

    public String set(int index, String str){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException("Index cannot be negative or greater than size");
	}
	String x = data[index];
	data[index] = str;
	return x;
    }

    public void add(int index, String str){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException("Index cannot be negative or greater than size");
	}
	if (size < data.length){
	    for(int i = size; i > index; i--){
		data[i] = data [i - 1];
	    }
	    data[index] = str;
	    size++;
	}else{
	    grow();
	    add(index, str);
	}
    }

    public String remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException("Index cannot be negative or greater than size");
	}

	String x = "";
	for(int i = 0; i < size; i++){
	    if(i == index){
		x = data[i];
		data[i] = data[i + 1];
	    }else if(i > index){
		data[i] = data[i + 1];
	    }
	}
	size--;
	return x;
    }

    public String[] toArray(){
	String[] x = new String[size];
	for(int i = 0; i < size; i++){
	    x[i] = data[i];
	}
	return x;
    }

    public int indexOf(String str){
	boolean isThere = false;
	int x = 0;
	for(int i = 0; i < size; i++){
	    if(str.compareTo(data[i]) == 0){
		x = i;
		isThere = true;
		break;
	    }
	}
	if(isThere){
	    return x;
	}else{
	    return -1;
	}
    }

    public int lastIndexOf(String str){
	boolean isThere = false;
	int x = 0;
	for(int i = size - 1; i >= 0; i--){
	    if(str.compareTo(data[i]) == 0){
		x = i;
		isThere = true;
		break;
	    }
	}
	if(isThere){
	    return x;
	}else{
	    return -1;
	}	
    }
	    
    public String toString(){

	String temp = "";

	 for(int i = 0; i < size; i++){
	     temp += data[i];
	     if(i < size - 1){
		 temp += ", ";
	     }
	 }

	 return "[" + temp + "]";
     }

    public String toStringDebug(){
	String temp = "";

	for(int i = 0; i < data.length; i++){
	    if(i < size){
		temp += data[i];
	    }else{
		temp += "_";
	    }

	    if(i < data.length - 1){
		temp += ", ";
	    }
	}

	return "[" + temp + "]";
    }
}


