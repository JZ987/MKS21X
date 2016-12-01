public class ArrayMethods{

    public static int rowSum(int[][] AR, int x){
	int sum = 0;
	for(int i = 0; i < AR[x].length; i++){
	    sum += AR[x][i];
	}
	return sum;
    }

    public static int columnSum(int[][] AR, int x){
	int sum = 0;
	for(int i = 0; i < AR.length; i++){
	    sum += AR[i][x];
	}
	return sum;
    }

    public static int[] allRowSums(int[][] AR){
	int[] result = new int[AR.length];
	for(int i = 0; i < AR.length; i++){
	    result[i] = rowSum(AR, i);
	}
	return result;
    }

    public static int[] allColumnSums(int[][] AR){
	int[] result = new int[AR[0].length];
	for(int i = 0; i < AR[0].length; i++){
	    result[i] = columnSum(AR, i);
	}
	return result;
    }

    public static boolean isRowMagic(int [][] AR){
	boolean temp = true;
	int[] ar = allRowSums(AR);
	for(int i = 0; i < ar.length - 1; i++){
	    if(ar[i] != ar[i+1]){
		temp = false;
		break;
	    }
	}
	return temp;
    }

    public static boolean isColumnMagic(int[][] AR){
	boolean temp = true;
	int[] ar = allColumnSums(AR);
	for(int i = 0; i < ar.length - 1; i++){
	    if(ar[i] != ar[i+1]){
		temp = false;
		break;
	    }
	}
	return temp;
    }
    
    public static String printArray(int[] x){
	String temp = "";
	for(int i = 0; i < x.length; i++){
	    temp += x[i];
	    if(i < x.length - 1){
		temp += ", ";
	    }
	}
	return "[" + temp + "]";
    }
}
