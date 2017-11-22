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

    public String subSequence(){
	return "";
    }

}
