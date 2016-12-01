public class Driver{

    public static void main(String[] args){

	int[][] test = {{1, 2, 3, 4, 5},
			 {3, 4, 5, 1, 2},
			 {5, 3, 1, 4, 2}};

	/*int[][] test = new int[4][3];
	
	for(int i = 0; i < test.length; i++){
	    for(int j = 0; j < test[i].length; j++){
		test[i][j] = (int)(Math.random() * 20);
	    }
	    }*/

	int[] x = ArrayMethods.allRowSums(test);
	int[] y = ArrayMethods.allColumnSums(test);
	
	System.out.println(ArrayMethods.columnSum(test, 0));
	System.out.println(ArrayMethods.columnSum(test, 1));
	System.out.println(ArrayMethods.columnSum(test, 2));
	//System.out.println(columnSum(test, 3));
			   
	System.out.println(ArrayMethods.rowSum(test, 0));
	System.out.println(ArrayMethods.rowSum(test, 1));
	System.out.println(ArrayMethods.rowSum(test, 2));

	System.out.println(ArrayMethods.printArray(x));
	System.out.println(ArrayMethods.printArray(y));

	System.out.println(ArrayMethods.isRowMagic(test));
	System.out.println(ArrayMethods.isColumnMagic(test));
    }
}
