import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch  {
    
    private char[][]data;
    private Random randgen;
    private ArrayList<String>wordsToAdd = new ArrayList<String>();
    private ArrayList<String>wordsAdded = new ArrayList<String>();
    private int seed;
    private String file;


    /**Initialize the grid to the size specified 
     *fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch( int rows, int cols, String fileName){
	this( rows, cols, fileName, new Random().nextInt());
    }
    
    public WordSearch(int rows, int cols, String fileName, int randSeed){
	file = fileName;
	seed = randSeed;
	randgen = new Random(seed);
	data = new char[rows][cols];
	clear();
  
	try{
	    File f = new File(fileName);//can combine
	    Scanner in = new Scanner(f);//into one line
	 
	    while(in.hasNext()){
		String word = in.nextLine().toUpperCase();
	        wordsToAdd.add( word);
		//System.out.println(word);
	    }
	    
	}catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName);
	    //e.printStackTrace();
	    System.exit(1);
	}
	addAllWords();
	
    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
	for (int i = 0; i < data.length; i++){
	    for (int x = 0; x < data[i].length;  x++){
		data[i][x] = '_';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
	System.out.println("\n" + data.length + "X" + data[0].length + "\t seed: " + seed + "\t file: " + file + "\n");
	String str = "";
	for (int i = 0; i < data.length; i++){
	    for (int x = 0; x < data[i].length; x++){
		str += data[i][x] + " ";
	    }
	    str += "\n";

	}

	if (wordsAdded.size() == 0) {
	    str += "\n No words could be added to your word search. \n Try: \n" +
		"(1) Using a text file with more words \n"+
		"(2) Increasing the amount of rows and/or columns \n";
	}
	
	return str;
    }

    // add word starting at given row and column
    //increment row and column -1, 0, or 1
    private boolean addWord(String word,int row, int col, int rInc, int cInc){

	int rLimit = (row + (word.length() * rInc ) -rInc);
	int cLimit = (col + (word.length() * cInc ) -cInc);	

	if ((rInc != 0 || cInc != 0)&&
	    (rLimit < data.length)&&
	    (rLimit >= 0) &&
	    (cLimit < data[row].length)&&
	    (cLimit >= 0)){

	    for (int x = row, y = col, i = 0; i < word.length(); i++, x += rInc, y+= cInc){
		if (!(data[x][y] == word.charAt(i) ||
		      data[x][y] == 0 ||
		      data[x][y] == '_')) {
		    //if word does not fit or overlap properly, do not add the word
		    //System.out.println("first false");
		    return false;
		}
	    }

	    for (int x = row, y = col, i = 0; i < word.length(); i++, x += rInc, y+= cInc){

		data[x][y] = word.charAt(i);
		

	    }
	    //System.out.println("true");
;
	    return true;
	}
	//System.out.println("last false");
  
	return false; 
    }

    // attempt to add all words in wordsToAdd
    private boolean addAllWords(){
	
        for (int i = 0; i < wordsToAdd.size() ; i++){
	    //System.out.println(wordsToAdd.toString());
	    int index = randgen.nextInt(wordsToAdd.size());
	    if(addWord(wordsToAdd.get(index),
		    randgen.nextInt(data.length),
		    randgen.nextInt(data[0].length),
		    randgen.nextInt(3)-1,
		    randgen.nextInt(3)-1)
	       ){
		wordsAdded.add(wordsToAdd.get(index));
	    }


	}

	return true;
    }

    //replace all '_' with a random letter
    private void fillBlanks() {

	String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	for (int r = 0; r < data.length; r ++) {
	    for (int c = 0; c < data[0].length; c++) {
		if (data[r][c] == '_') {
		    data[r][c] = letters.charAt(randgen.nextInt(26));
		}
	    }
	}
    }

    //return words in wordsAdded in a somewhat visually appealing style
    private String wordBank() {
	String words = "-----------------------------------------\n Find the following words! \n-----------------------------------------\n";
	for (int i = 0; i < wordsAdded.size(); i ++) {
	    words += wordsAdded.get(i) + "\t\t";
	    if (i%3 == 2) {
		words += "\n";
	    }
	}

	words += "\n-----------------------------------------";
	return words;
    }


    public static void main(String[] args){
	

	String error =
	    "\nPlease enter parameters in one of the following formats: \n" +
	    "<rows> <cols> <filename> \n\n" +
	    "<rows> <cols> <filename> <seed> \n\n" +
	    "<rows> <cols> <filename> <seed> key \n\n" +
	    "\nNote: \n" +
	    "<rows> must be an integer greater than 0 \n\n"+
	    "<cols> must be an integer than 0 \n\n"+
	    "<filename> must be the name of a text file \n\n"+
	    "<seed> must be an integer \n\n" ;

	WordSearch puzzle;
	int r = 0; 
	int c = 0;
	String f = "";
	int s = 0;

	//must have at least 3 args
        if (args.length < 3 ){
	    System.out.println(error);
	}
	    
	//row and cols must be int
	if (args.length >= 3){	
	    try {
	        r = Integer.parseInt(args[0]);
		c = Integer.parseInt(args[1]);
	    } catch (NumberFormatException e) {
		System.err.println(error);
		System.exit(1);
	    }

	    if (r <= 0 || c <= 0){
		System.out.println(error);
		System.exit(1);
	    }

	    f = args[2];
	    //if (!f.substring(f.length() - 4).equals(".txt")){
	    //	System.out.println(error);
	    //	System.exit(1);
	    //}
	}

	//seed must be an int
	if (args.length >= 4) {
	    try {
	        s = Integer.parseInt(args[3]);
	    } catch (NumberFormatException e) {
		System.err.println(error);
		System.exit(1);
	    }

	    

	}
	// prints puzzle and word bank given rows, cols, file 
	if (args.length == 3) {
	    puzzle = new WordSearch (r,c, args[2]);
	    puzzle.fillBlanks();
	    System.out.println(puzzle);
	    System.out.println(puzzle.wordBank());
	   
	}

	if (args.length >= 4) {
	    puzzle = new WordSearch (r, c, f, s);

	    // checks if user wants puzzle or key
	    if (args.length >= 5 && args[4].equals("key") ){
		System.out.println(puzzle);
	    }
	    else {
		puzzle.fillBlanks();
		System.out.println(puzzle);
	    }
	    //prints word bank
	    System.out.println(puzzle.wordBank());

	}

	   
	    
    }

    
}
