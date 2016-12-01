public class HomeworkTest {

    public static double fToC(double f){
        return ((f-32)*5)/9;
    }
    
    public static double cToF(double c){
        return ((c * 9)/5) + 32;
    }
    
    public static void main(String[]args){

        System.out.println(fToC(95));
        System.out.println(cToF(35));
        System.out.println(fToC(30));
        System.out.println(cToF(99));
    }
}
