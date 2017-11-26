public class ReversedCharSeq{
    private String str;

    public ReversedCharSeq(String s) {
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

    public ReversedCharSeq subSequence(int start, int end){
	String temp = "";
	for (int i = end-1; i >= start; i--){
	    temp += str.charAt(i);	    
	}
	ReversedCharSeq sub = new  ReversedCharSeq(temp);
	return sub;

    }

    public String toString(){
	return str;
    }


    public static void main(String[]args){
	
	ReversedCharSeq s = new ReversedCharSeq("hello world");
	System.out.println(s.length() + ".... expecting 11");
	System.out.println(s + ".... expecting dlrow olleh");
	System.out.println(s.charAt(1) + ".... expecting l");
	System.out.println(s.subSequence(2, 7) + ".... expecting row o");

    }

}
