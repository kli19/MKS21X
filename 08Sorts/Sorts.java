import java.util.Arrays;
public class Sorts{
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
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

    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
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


    public static void main(String[]args){
	int[] a = {64, 25, 12, 22, 11};
	System.out.println(Arrays.toString(a));

	System.out.println(isSorted(a));

	selectionSort(a);
	System.out.println(Arrays.toString(a));


	System.out.println(isSorted(a));
    }
}
