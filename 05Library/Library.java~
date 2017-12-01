import java.util.ArrayList;
import java.util.Collections;

public class Library {
    ArrayList<LibraryBook> bookList;
    public Library () {
	bookList = new ArrayList<LibraryBook> ();
    }

    /**
     * adds the given book to the library
     * @param book
     */
    public void addBook (LibraryBook book) {
	bookList.add(book);
    }

    /**
     * prints all books in the library
     */
    public void printLibrary () {
	System.out.println ("\nListing of books in the library\n");
	for (LibraryBook book: bookList)
	    System.out.println (book );//"; "+ book.circulationStatus());//.getCallNumber());
	System.out.println ("End of book listing\n");
    }

    /**
     * locates a book in the library
     * @param book book being search in the library
     * @return book object if book is found
     *         null otherwise
     */
    public LibraryBook findBook (LibraryBook book) {
	int index = Collections.binarySearch(bookList, book);
	if (index >= 0)
	    return bookList.get(index);
	else
	    return null;
    }

    /**
     * sort books in the library by call number
     */
    public void sortLibrary () {
	Collections.sort(bookList);
    }

    /**
     * performs processing for checking a book out of the library
     * @param patron  person checking out book
     * @param dueDate date book is due to be returned
     * @param callNum call number of book
     */
    public void checkout (String patron, String dueDate, String callNum) {
	LibraryBook searchItem = new CirculatingBook ("", "", "", callNum);
	LibraryBook book = findBook(searchItem);
	if (book == null)
	    System.out.println ("Book " + callNum + " not found -- checkout impossible\n");
	else
	    book.checkout (patron, dueDate);
    }

    /**
     * processes checked-out book that is being returned
     * @param callNum call number of book being returned
     */
    public void returned (String callNum) {
	LibraryBook searchItem = new CirculatingBook ("", "", "", callNum);
	LibraryBook book = findBook(searchItem);
	if (book == null)
	    System.out.println ("Book " + callNum + " not found -- return impossible\n");
	else
	    book.returned ();
    }

    /**
     * main testing program
     * @param args  not used
     */
    public static void main (String args[]) {

	Library lib = new Library ();

	// set up library
	lib.addBook(new ReferenceBook ("Newt",
				       "Fantastic Beasts and Where to Find Them",
				       "203-2034-2-21-9", 
				       "22-C4-03", 
				       "cooking"));

	lib.addBook(new ReferenceBook ("Kang Kodos & Friends",
				       "How To Cook for Forty Humans",
				       "5-1334-5260-2", 
				       "5E.2A.34", 
				       "cooking"));

	lib.addBook(new ReferenceBook ("Dr. Demento",
				       "Getting to Know Your Alternate Personalities",
				       "873-464-78-94-2", 
				       "BE-0A-D3", 
				       "self improvement"));

	lib.addBook(new ReferenceBook ("Dr. Giggles",
				       "Companion for Faking your way through Dental School, practice Exams",
				       "043-208-70-29-3", 
				       "02-3A-43", 
				       "self improvement"));


	lib.addBook(new CirculatingBook ("Dr. Giggles",
				       "Faking your way through Dental School, tried and tested techniques",
				       "893-408-22-92-22", 
				       "02-3A-46"));

	lib.addBook(new CirculatingBook  ("Homer",
				      "The Odyssey",
				      "0-2304-0230-2", 
				      "DE.EA.DB"));

	lib.addBook(new CirculatingBook  ("Homer Simpson",
				      "The Odyssey to the Donut Shop",
				      "4-554-23430-5", 
				      "3E.55"));


	// sort books by call number
	lib.sortLibrary();

	// print library
	lib.printLibrary();

	// some users check out and return books
	System.out.println("Checkout ");
	lib.checkout("Harry Potus", "March 1, 2017", "3E.55");

	System.out.println("SUPPOSED TO FAIL: Checkout of reference book");
	lib.checkout("Goofy", "March 6, 2017", "02-3A-43" );

	System.out.println("Returned");
	lib.returned("3E.55");


	System.out.println("Checkout ");
	lib.checkout("Invader Zim", "April 1, 2012", "DE.EA.DB");


	System.out.println("SUPPOSED TO FAIL: No Such Book");
	lib.checkout("Goofy", "February 28, 2012", "12345");


	System.out.println("SUPPOSED TO FAIL: Return non-existant book impossible");
	lib.returned("adsf");

	System.out.println("Checkout ");
	lib.checkout("Polyphemus", "March 28, 2017", "DE.EA.DB");

	// print final status of library
	lib.printLibrary();
    }
}
