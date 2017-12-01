public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String ISBN, String callNumber){
	super(author, title, ISBN, callNumber);
	currentHolder = null;
	dueDate = null;	
    }

    public void checkout(String patron, String due){

    }

    public void returned(){

    }

    public String circulationStatus(){
	//placeholder so code will compile
	return "book available on shelves";
    }



}
