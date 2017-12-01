public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String ISBN, String callNumber){
	super(author, title, ISBN, callNumber);
	currentHolder = null;
	dueDate = null;	
    }

    public String getCurrentHolder(){return currentHolder;}
    public void setCurrentHolder(String currentHolder){this.currentHolder = currentHolder;}

    public String getDueDate(){return dueDate;}
    public void setDueDate(String dueDate){this.dueDate = dueDate;}

    public void checkout(String patron, String due){
	setCurrentHolder(patron);
	setDueDate(due);
    }

    public void returned(){
	setCurrentHolder(null);
	setDueDate(null);
    }

    public String circulationStatus(){
	//not sure
	if (getCurrentHolder()==null){
	    return "book available on shelves";
	}

	return getCurrentHolder() + ", " + getDueDate();
    }

    public String toString(){
	return
	    super.toString() + ", " +
	    circulationStatus();
    }



}
