public class Book {

    private String author;
    private String title;
    private String ISBN;

    public Book(){
	author = "";
	title = "";
	ISBN = "";
    }

    public Book(String Author, String Title, String isbn){
	author = Author;
	title = Title;
	ISBN = isbn;
    }

    public void setAuthor(String Author){
	author = Author;
    }

    public void setTitle(String Title){
	title = Title;
    }

    public void setISBN(String isbn){
	ISBN = isbn;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN;
    }

    public String toString(){
	return "Author: " + author + "\nTitle: " + title + "\nISBN: " + ISBN;
    }
}
