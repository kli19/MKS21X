import java.util.Arrays;
public class Sorts{

    public static String name(){
	return "10.Li.Karen"; 
    }

    public static boolean isSorted(int[]ary){
	for(int i = 0; i < ary.length-1; i++){
	    if (ary[i] > ary[i+1]){
		return false;
	    }
	}
	return true;
    }
    
    public static void bogoSort(int[]ary){
	while(!isSorted(ary)){
	    for (int i = 0; i < ary.length; i++){
		int temp = ary[i];
		int newSpot = (int)(Math.random()*ary.length);
		ary[i] = ary[newSpot];
		ary[newSpot] = temp;		    
	    }
	}
    }

    public static void selectionSort(int[] data){
      
	for (int i = 0; i < data.length; i++){
	    int next = data[i];
	    int index = i;
	    for (int j = i; j < data.length; j++){
		if (data[j] < next){
		    next = data[j];
		    index = j;
		}	      
	    }
	    data[index] = data[i];
	    data[i] = next;	  
	}
    }

    public static void insertionSort(int[] data){
	for (int i = 1; i < data.length; i++){
	    int temp = data[i]; 
	    int index = i; 
	    for (int j = i-1; j >= 0 && data[j]>temp; j--){
		data[j+1] = data[j]; 
		index = j;
	    }
	    data[index] = temp;
	}
    }

    public static void bubbleSort(int[] data){
	for (int i = 0; i < data.length; i++){
	    int max;
	    for (int j = 1; j < data.length - i; j++){
		if ( data[j-1] > data[j]){
		    max = data[j-1];
		    data[j-1] = data[j];
		    data[j] = max;
		}

	    }
	}
    }
    
    public static void main(String[]args){
        
	int[] a = new int[5];
	for (int i = 0; i < a.length; i++){
	    a[i] = (int)(Math.random()*100);
	}

	//testing selectionSort
	//System.out.println(Arrays.toString(a)); //[64, 25, 12, 22, 11]
	//System.out.println(isSorted(a)); //false
	//selectionSort(a); 
	//System.out.println(Arrays.toString(a)); //[11, 12, 22, 25, 64]
	//System.out.println(isSorted(a)); //true

	// testing bogoSort
	//System.out.println(Arrays.toString(a));
	//bogoSort(a);
	//System.out.println(Arrays.toString(a));

	// testing insertionSort
	//System.out.println(Arrays.toString(a));
	//insertionSort(a);
	//System.out.println(Arrays.toString(a));

	
	//testing bubbleSort
	//System.out.println(Arrays.toString(a));
	//bubbleSort(a);
	//System.out.println(Arrays.toString(a));
    }
  
}
