abstract class LibraryBook extends Book implements Comparable<LibraryBook>{

    private String callNumber;

    public LibraryBook(String author, String title, String isbn, String callNum){
	super(author, title, isbn);
        callNumber = callNum;
    }
    
    public void setCallNumber(String callNum){
	callNumber = callNum;
    }

    public String getCallNumber(){
	return callNumber;
    }

    abstract void checkout(String patron, String due);

    abstract void returned();

    abstract String circulationStatus();

    public int compareTo(LibraryBook o){
	return callNumber.compareTo(o.getCallNumber());
    }

    public String toString(){
	return super.toString() + "\nCirculation Status: " + circulationStatus() + "\nCall Number: " + callNumber;
    }
}
