public class ReversedCharSequence{
    private String str;

    public ReversedCharSequence(String s) {
	String temp = "";
	for (int i = s.length() -1; i >= 0; i--){
	    temp += s.charAt(i);
	}

        str = temp;
    }

    public char charAt(int index){
	return str.charAt(index);
    }

    public int length(){
	return str.length();
    }

    public ReversedCharSequence subSequence(int start, int end){
	String temp = "";
	for (int i = end-1; i >= start; i--){
	    temp += str.charAt(i);	    
	}
	ReversedCharSequence sub = new  ReversedCharSequence(temp);
	return sub;

    }

    public String toString(){
	return str;
    }


    public static void main(String[]args){
	
	//ReversedCharSequence s = new ReversedCharSequence("hello world");
	//System.out.println(s.length() + ".... expecting 11");
	//System.out.println(s + ".... expecting dlrow olleh");
	//System.out.println(s.charAt(1) + ".... expecting l");
	//System.out.println(s.subSequence(2, 7) + ".... expecting row o");


    
    }
}
