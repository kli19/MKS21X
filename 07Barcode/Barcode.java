public class Barcode implements Comparable<Barcode>{
    private String[] dictionary = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    private String zip;
    private String code;

    public Barcode(String zip){
	this.zip = zip;
	this.zip += checksum();
	String temp = "";
	for (int i = 0; i < this.zip.length(); i++){
	    temp += dictionary[Integer.parseInt(this.zip.substring(i, i+1))];
	}
	code = "|" +  temp + "|";
    }

    public String getZip(){
	return zip;
    }

    public String getCode(){
	return code;
    }

    public String toString(){
	return getZip() + "\n" + getCode();
    }

	
    public int compareTo(Barcode other){
	return this.getZip().compareTo(other.getZip());
    }

    public Boolean equals(Barcode other){
	return compareTo(other) == 0;
    }

    public int checksum(){
	int sum = 0;
	for (int i = 0; i < zip.length(); i++){
	    sum += Integer.parseInt(zip.substring(i, i+1));
	}
	return sum % 10 ;
    }

    public static void main(String[]args){
    	Barcode a = new Barcode("11592");
    	Barcode b = new Barcode("11592");
    	Barcode c = new Barcode("00000");
    
    	System.out.println("a: " + a);
    	System.out.println("b: " + b);
    	System.out.println("c: " + c);
    
	System.out.println(a.equals(b)); //true
    	System.out.println(a.equals(c)); //false
	
	
    }
}