public abstract class Book implements Comparable<Book>{

    private String author;
    private String title;
    private int ISBN;

    public Book(){
    }

    public Book(String author, String title, int ISBN){
	this.author = author;
	this.title = title;
	this.ISBN = ISBN;
    }

    public String getAuthor(){return author;}
    public String getTitle(){return title;}   
    public int getISBN(){return ISBN;}

    public void setAuthor(String author){this.author = author;}
    public void setTitle(String title){this.title = title;}
    public void setISBN(int ISBN){this.ISBN = ISBN;}

    public String toString(){
	return
	    getTitle() + ", " +
	    getAuthor() + ", " +
	    getISBN();
	    
    }
    
}