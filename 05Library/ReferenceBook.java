public class ReferenceBook extends LibraryBook{
    private String collection;

    public ReferenceBook(String author, String title, String ISBN, String callNumber, String collection){
	super(author, title, ISBN, callNumber);
	this.collection = collection;
    }

    public String getCollection(){return collection;}
    public void setCollection(String collection){this.collection = collection;}


    public void checkout(String patron, String due){
	throw new UnsupportedOperationException("cannot checkout a reference book");
    }

    public void returned(){
	throw new UnsupportedOperationException("reference book could not have been checked out -- return impossible");
    }
    
    public String circulationStatus(){
	return "non-circulating reference book";
    }
    
    public String toString(){
	return
	    super.toString() + ", " +
	    getCollection();
    }
}

    



