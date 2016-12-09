public class ReferenceBook extends LibraryBook{

    private String collection;

    public ReferenceBook(String author, String title, String isbn, String callNum, String collection){
	super(author, title, isbn, callNum);
	this.collection = collection;
    }

    public void setCollection(String collection){
	this.collection = collection;
    }

    public String getCollection(){
	return collection;
    }

    public void checkout(String patron, String due){
	System.out.println("The patron cannot check out a reference book");
    }

    public void returned(){
	System.out.println("Reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
	return "Non-circulating reference book";
    }

    public String toString(){
	return super.toString() + "\nCollection: " + collection + "\n";
    }
}
