public class SuperArray{
    private String[] data;
    private int size;

    public SuperArray(){
	data = new String[10];
	size = 0;
    }

    public SuperArray(int capacity) {
	data = new String[capacity];
	size = 0;
    }

    public void clear(){
	data = new String[data.length];
	size = 0;
    }

    public int size(){
	return size;
    }
    
    public boolean isEmpty(){
	return size == 0;
    }

    public boolean add(String element){
        add(size(), element);
	return true;
    }

    public String get(int index){
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }

    public String toString(){
	String dataString = "[";
	for (int i = 0; i < size; i++){
	    dataString += data[i];
	    if (i < size -1) {
		dataString += ", ";
	    }
	}
	dataString += "]";
	return dataString;
    }


    
    public String set(int index, String element){
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	String old = data[index];
	data[index] = element;
	return old;
    }

    private void resize() {
	String[] temp = new String[2*data.length+1];
	for (int i = 0; i < data.length; i++ ) {
	    temp[i] = data[i];
	}
	data = temp;
    }

    public boolean contains(String target) {
	for (int i = 0; i < size; i++){
	    if (data[i].equals(target)) {
		return true;
	    }
	}
	return false;
    }


    public int indexOf(String element) {
	for (int i = 0; i < size; i++){
	    if (data[i].equals(element)){
		return i;
	    }
	}
	return -1;
    }
    public int lastIndexOf(String element) {
	for (int i = size - 1; i >= 0; i--){
	    if (data[i].equals(element)){
		return i;
	    }
	}
	return -1;
    }

    public void add(int index, String element){
	if (index < 0 || index > size()) {
	    throw new IndexOutOfBoundsException();
	}
        else {
	    if (size == data.length) {
		resize();
	    }

	    for (int i = size(); i > index; i--) {
		data[i] = data[i-1];
	    }
	    data[index] = element;
	    size++;

	}
    }

    public String remove(int index){
	String[] temp;
	String removed = "null";
	if (!(index < 0 || index > size())){
	    removed = data[index];
	    temp = new String[data.length];

	    for (int i = 0; i < index; i++){
		temp[i] = data[i];
	    }

	    for (int i = index; i < size(); i++){
		temp[i] = data[i+1];
	    }

	    size--;

	    data = temp;
	}
	return removed;
    }

    public boolean remove(String element){
        for (int i = 0; i < size; i++){
	    if (data[i].equals(element)){
		remove(i);
		return true;
	    }
	}
	return false;
    }
}
