public class Sorts{

    public static String name(){
	return "09.Zheng.Jack";
    }
    
    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[] data){ 
        int x = 0;
	for(int i = 0; i < data.length(); i++){
	    int minSoFar = data[i];
	    for(int j = i; j < data.length(); j++){
		if(minSoFar >= data[j]){
		    minSoFar = data[j];
		    x = j;
		}
	    }
	    data[x] = data[i];
	    data[i] = minSoFar;
	}
    }


    public static void main(String[] args){
	
	

	
    }
}
