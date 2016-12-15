import java.util.*;

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
	for(int i = 0; i < data.length; i++){
	    int minSoFar = data[i];
	    for(int j = i; j < data.length; j++){
		if(minSoFar >= data[j]){
		    minSoFar = data[j];
		    x = j;
		}
	    }
	    data[x] = data[i];
	    data[i] = minSoFar;
	}
    }

    /**Insertion sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void insertionSort(int[] data){
	int currentNum;
	for(int i = 1; i < data.length; i++){
	    currentNum = data[i];
	    for(int j = i - 1; j >= 0; j--){
		if(j == 0 && currentNum < data[0]){
		    for(int x = i; x > j; x--){
			data[x] = data[x-1];
		    }
		    data[j] = currentNum;
		    break;
		}else if(currentNum > data[j]){
		    for(int x = i; x > j; x--){
			data[x] = data[x-1];
		    }
		    data[j + 1] = currentNum;
		    break;
		}
	    }
	}
    }

    /**Bubble sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void bubbleSort(int[] data){
	int tempNumber;
	for(int j = data.length; j >= 0; j--){
	    for(int i = 0; i < data.length - 1; i++){
		if(data[i] > data[i+1]){
		    tempNumber = data[i+1];
		    data[i+1] = data[i];
		    data[i] = tempNumber;
		}
	    }
	}
    }

    private static void printArray(int[] data){
	String str = "[";
	for(int i = 0; i < data.length; i++){
	    str += data[i];
	    if(i < data.length - 1){
		 str += ", ";
	     }
	}
	System.out.println(str + "]");
    }








    public static void main(String[] args){
	
	int[] data = {64, 25, 12, 22, 11, 75};
	int[] data2 = {5, 4, 3, 2, 1, 0, -1, -2, -3, -4};
    

	if(true){
	    long startTime = System.currentTimeMillis();
	    selectionSort(data);
	    long endTime = System.currentTimeMillis();
	    System.out.println(endTime - startTime);
	}

	//printArray(data);
	//selectionSort(data);
	//selectionSort(data2);
	//insertionSort(data);
	//insertionSort(data2);
	//bubbleSort(data);
	//bubbleSort(data2);
	printArray(data);
	//printArray(data2);
    }
}
