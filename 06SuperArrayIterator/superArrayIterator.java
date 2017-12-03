import java.util.*;
public class superArrayIterator implements Iterator<String> {
    int next;
    SuperArray data;
    public superArrayIterator(SuperArray s){
	int next = 0;
	data = s;
    }
    public String next(){
	next++;
	return data.get(next-1);
    }

    public boolean hasNext(){
	return next <= data.size();
    }
}
