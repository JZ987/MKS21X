public class StringDemo{

    public static void main(String[]args){

        String s1, s2, s3, s4;
        s1 = "Hello my name is Bob.";
        s2 = "Hello my name is Bob.";
        s3 = "Hello my name is Dab.";
        s4 = "";

        
        System.out.println(s1.length());//returns 21

        
        System.out.println(s1.charAt(4));//returns "o"
        
        //System.out.println(s1.charAt(45));
        /*Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 45
          at java.lang.String.charAt(String.java:658)
          at StringDemo.main(StringDemo.java:16)

          The problem that the program tries to tell me is that I'm giving it an index that is beyond the length of the string.
          The StringDemo.main(StringDemo.java:16) tells me where to find this error. It is in the main function of the StringDemo class at line 16.
          We can prevent this by first finding out the length of the string we're trying to use and limit the parameter in that range.*/
        
        //System.out.println(s1.charAt(-3));
        /* Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: -3
           at java.lang.String.charAt(String.java:658)
           at StringDemo.main(StringDemo.java:25)

           Same problem as above. Index out of range.*/


        System.out.println(s1.equals(s2)); //returns true
        System.out.println(s1.equals(s3)); //returns false
        System.out.println(s1.equals("Hello my name is Bob.")); //returns true
        System.out.println(s4.equals("")); //returns true
        System.out.println(s1.equals(1234567890)); //returns false


        System.out.println(s1.compareTo(s2)); //returns 0
        System.out.println(s1.compareTo(s3)); //returns -2
        System.out.println(s3.compareTo(s1)); //returns 2
        
        // System.out.println(s1.compareTo(123));
        /*StringDemo.java:44: error: method compareTo in class String cannot be applied to given types;
          System.out.println(s1.compareTo(123));
                             ^
          required: String
          found: int
          reason: actual argument int cannot be converted to String by method invocation conversion

          The problem here is that the function requires a string but I'm giving it an int.*/


        System.out.println(s1.indexOf("name")); //returns 9
        System.out.println(s4.indexOf("")); //returns 0
        System.out.println(s3.indexOf("i")); //returns 14
        System.out.println(s1.indexOf(23)); //returns -1


        System.out.println(s1.substring(4,12)); //returns "o my nam"
        System.out.println(s1.substring(1,1)); //returns nothing
        
        // System.out.println(s1.substring(-3,0));
        /*Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: -3
        at java.lang.String.substring(String.java:1904)
        at StringDemo.main(StringDemo.java:51)

        The problem here is that I'm giving an index that is out of bound of the string. The substring function does not accept
        a negative int as one of its parameters.*/
               
        //System.out.println(s1.substring(2,86));
        /*Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 86
        at java.lang.String.substring(String.java:1907)
        at StringDemo.main(StringDemo.java:62)

        The endIndex is out of the range of the string. The max endIndex can have is the length() of the string.*/
        
        //System.out.println(s1.substring(8,6));
        /*Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: -2
        at java.lang.String.substring(String.java:1911)
        at StringDemo.main(StringDemo.java:69)

        The problem here is that the beginIndex is larger than the endIndex. The "string index out of range" shows how much the beginIndex
        is larger than the endIndex.*/


        System.out.println(s1.substring(3)); //returns "lo my name is Bob."
        
        //System.out.println(s1.substring("Hello"));
        /*StringDemo.java:79: error: no suitable method found for substring(String)
          System.out.println(s1.substring("Hello"));
                             ^
          method String.substring(int,int) is not applicable
          (actual and formal argument lists differ in length)
          method String.substring(int) is not applicable
          (actual argument String cannot be converted to int by method invocation conversion)

          The problem here is that I'm giving the function a string instead of (int) or (int, int) that is required.*/
    }
}
                                        
