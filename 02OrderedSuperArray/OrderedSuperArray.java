public class OrderedSuperArray extends SuperArray{

    /*constructor initializes an empty List*/
    public OrderedSuperArray(){
	super();
    }

    public OrderedSuperArray(int capacity){
	super(capacity);
    }

    public OrderedSuperArray(String[] ary){
	super(ary.length);
	for (int i = 0; i<ary.length; i++) {
	    add(ary[i]);
	}
	
    }

    public void add(int index, String value){
	add(value);
    }


    public boolean add(String value){
	int index = findIndexBinary(value);
	super.add(index, value);
          
	return true;
    }

    private int findIndex(String value){
	for (int i = 0; i < size(); i++){
	    if (value.compareTo(get(i))<0){        
		return i;
	    }
	}
	return size();
    }

    public String set(int index, String element) {
	throw new UnsupportedOperationException();
    }

    private int findIndexBinary(String element){
	int start = 0;
	int end = size()-1;
	int middle = size()/2;

	while (start != middle && end != middle) {
	    if (element.compareTo(get(middle))<=0){
		end = middle;
		middle = (end + start +1 ) / 2;
		//System.out.println("end: " + end);
	    }
	    else {
		start = middle;
		middle = (end + start +1 ) / 2;
		//System.out.println("start: "+start);
	    }
	}
	//System.out.println("start: "+start);
	//System.out.println("end: "+end);
	//System.out.println("middle: "+middle );
	if (size() > 0 && element.compareTo(get(middle))>=0){
	    while ( middle < size() && element.compareTo(get(middle))>=0){
		middle +=1;
	    }
	}
	else if (size()>0 &&  element.compareTo(get(middle))<0){
	    while (middle < size() && middle >0 && element.compareTo(get(middle-1))<0) {
		middle--;
	    }
	}

	//System.out.println("startF: "+start);
	//System.out.println("endF: "+end);
	//System.out.println("middleF: "+middle );
	//System.out.println(this+"\n");
	return middle;
	
    }

    public int indexOfBinary(String element) {

	int start = 0;
	int end = size()-1;
	int middle = end/2;

	while (start != middle && end != middle) {

	    if  (element.compareTo(get(middle))<=0){
		end = middle;
		middle = (end + start +1 ) / 2;

	    }
	    else if (element.compareTo(get(middle))>0) {
		start = middle;
		middle = (end + start +1 ) / 2;


	    }	
	}

	if (get(middle).equals(element)){
	    while (middle > 0 && get(middle-1).equals(element)){
	        middle--;
	    }
	    return middle;
	}

	return -1;
	
    }


    public int lastIndexOfBinary(String element){
	int index = indexOfBinary(element);
	while (index < size()-1&&  element.compareTo(get(index+1))==0){
	  index++;
		}
	return index;
    }
}
