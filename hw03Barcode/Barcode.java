import java.util.*;

public class Barcode implements Comparable<Barcode>{

    // instance variables
    private String _zip;
    private int _checkDigit;
    
    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    
    public Barcode(String zip){
	if(zip.length() != 5){
	    throw new IllegalArgumentException("Wrong length");
	}
	try{
	    Integer.parseInt(zip);
	}catch(Exception e){
	    throw new IllegalArgumentException("Should contain only numbers");
	}
	
	_zip = zip;
	_checkDigit = checkSum(zip);
    }

    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
	Barcode clone = new Barcode(_zip);
	return clone;
    }


    // postcondition: computes and returns the check sum for _zip
    private static int checkSum(String zip){
	int sum = 0;
	for(int i = 0; i < zip.length(); i++){
	    sum += Integer.parseInt(zip.substring(i,i+1));
	}
	return sum % 10;
    }

    //convert to zip
    public static String toZip(String code){
	if(code.length() != 32){
	    throw new IllegalArgumentException("Code length should be 32");
	}else if(code.charAt(0) != '|'){
	    throw new IllegalArgumentException("Your code should start with |");
	}else if(code.charAt(31) != '|'){
	    throw new IllegalArgumentException("Your code should end with |");
	}
	for(int i = 0; i < code.length(); i++){
	    if(code.charAt(i) != '|' && code.charAt(i) != ':'){
		throw new IllegalArgumentException("Your code should only contain : or |");
	    }
	}

	String zip = "";
	for(int i = 1; i < code.length() - 1; i+=5){
	    switch(code.substring(i, i+5)){
	    case ":::||": zip += "1";
		break;
	    case "::|:|": zip += "2";
		break;
	    case "::||:": zip += "3";
		break;
	    case ":|::|": zip += "4";
		break;
	    case ":|:|:": zip += "5";
		break;
	    case ":||::": zip += "6";
		break;
	    case "|:::|": zip += "7";
		break;
	    case "|::|:": zip += "8";
		break;
	    case "|:|::": zip += "9";
		break;
	    case "||:::": zip += "0";
		break;
	    default: throw new IllegalArgumentException("The code contains an incorrect pattern");
	    }
	}

	if(Character.getNumericValue(zip.charAt(5)) != checkSum(zip.substring(0,5))){
	    throw new IllegalArgumentException("Your checksum is invalid");
	}else{
	    return zip.substring(0,5); 
	}
    }

    //convert to code
    public static String toCode(String zip){
	if(zip.length() != 5){
	    throw new IllegalArgumentException("Wrong length");
	}
	try{
	    Integer.parseInt(zip);
	}catch(Exception e){
	    throw new IllegalArgumentException("Should contain only numbers");
	}
	
	String Zip = zip + checkSum(zip);
	String barcode = "|";
	for(int i = 0; i < Zip.length(); i++){
	    switch (Zip.charAt(i)){
	    case '1': barcode += ":::||";
		break;
	    case '2': barcode += "::|:|";
		break;
	    case '3': barcode += "::||:";
		break;
	    case '4': barcode += ":|::|";
		break;
	    case '5': barcode += ":|:|:";
		break;
	    case '6': barcode += ":||::";
		break;
	    case '7': barcode += "|:::|";
		break;
	    case '8': barcode += "|::|:";
		break;
	    case '9': barcode += "|:|::";
		break;
	    case '0': barcode += "||:::";
		break;
	    }
	}
	return barcode + "|";
	}

    //postcondition: format zip + check digit + Barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	return _zip + _checkDigit + "   " + toCode(_zip);
    }
    


    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	return _zip.compareTo(other._zip);
    }
    
}
