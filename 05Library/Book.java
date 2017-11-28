public abstract class Book implements Comparable<Book>{

    private String author;
    private String title;
    private String ISBN;

    public Book(){
    }

    public Book(String author, String title, String ISBN){
	this.author = author;
	this.title = title;
	this.ISBN = ISBN;
    }

    public String getAuthor(){return author;}
    public String getTitle(){return title;}   
    public String getISBN(){return ISBN;}

    public void setAuthor(String author){this.author = author;}
    public void setTitle(String title){this.title = title;}
    public void setISBN(String ISBN){this.ISBN = ISBN;}

    public String toString(){
	return
	    getTitle() + ", " +
	    getAuthor() + ", " +
	    getISBN();
	    
    }
    
}
