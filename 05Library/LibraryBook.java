public abstract class LibraryBook extends Book implements Comparable <LibraryBook>{
    private int callNumber;

    public LibraryBook(String author, String title, String ISBN, String callNumber){
	super(author, title, ISBN);
	this.callNumber = callNumber;
    }

    public String getCallNumber(){
	return callNumber;
    }
}
