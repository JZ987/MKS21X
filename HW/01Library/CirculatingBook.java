public class CirculatingBook extends LibraryBook{
    
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String isbn, String callNum){
	super(author, title, isbn, callNum);
	currentHolder = "";
	dueDate = "";
    }

    public void setCurrentHolder(String patron){
	currentHolder = patron;
    }

    public void setDueDate(String due){
	dueDate = due;
    }

    public String getCurrentHolder(){
	return currentHolder;
    }

    public String getDueDate(){
	return dueDate;
    }

    public void checkout(String patron, String due){
	currentHolder = patron;
	dueDate = due;
    }

    public void returned(){
	currentHolder = "";
	dueDate = "";
    }

    public String circulationStatus(){
	if(currentHolder.equals("") && dueDate.equals("")){
	    return "Book available on shelves";
	}else{
	    return " Borrowed by " + currentHolder + " and due on " + dueDate;
	}
    }

    public String toString(){
	return super.toString() + "\nCurrent Holder: " + currentHolder + "\nDue Date: " + dueDate + "\n";
    }  
}
