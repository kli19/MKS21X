public class Barcode implements Comparable<Barcode>{
    private static String[] dictionary = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    private String zip;

    public Barcode(String zip){
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
        try {
	    int s;
	    s = Integer.parseInt(zip);
	} catch (NumberFormatException e){
	    throw new IllegalArgumentException();
	}
	this.zip = zip;
    }

    public String getZip(){
	return zip;
    }

    public String getCode(){
	String code = "";
	for (int i = 0; i < zip.length(); i++){
	    code += dictionary[Integer.parseInt(zip.substring(i, i+1))];
	}
	code += dictionary[checksum(zip)];
	return "|" +  code + "|";

    }

    public String toString(){
	return getCode() + " (" + getZip() + ")";
    }

	
    public int compareTo(Barcode other){
	return this.getZip().compareTo(other.getZip());
    }

    public Boolean equals(Barcode other){
	return compareTo(other) == 0;
    }

    public static int checksum(String zip){
	int sum = 0;
	for (int i = 0; i < zip.length(); i++){
	    sum += Integer.parseInt(zip.substring(i, i+1));
	}
	return sum % 10 ;
    }

    public static String toCode(String zip){
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
        try {
	    int s;
	    s = Integer.parseInt(zip);
	} catch (NumberFormatException e){
	    throw new IllegalArgumentException();
	}
	String code = "";
	for (int i = 0; i < zip.length(); i++){
	    code += dictionary[Integer.parseInt(zip.substring(i, i+1))];
	}
	code += dictionary[checksum(zip)];
	return "|" +  code + "|";
    }

    public static String toZip(String code){
	return "";
    }

    public static void main(String[]args){
	
    	Barcode a = new Barcode("11592");
    	Barcode b = new Barcode("11592");
    	Barcode c = new Barcode("00000");
    
    	System.out.println("a: " + a);
    	System.out.println("b: " + b);
    	System.out.println("c: " + c);

	System.out.println(a.compareTo(b)); //0
	System.out.println(c.compareTo(a)); //negative
	System.out.println(a.compareTo(c)); //positive
	
	
	System.out.println(a.equals(b)); //true
    	System.out.println(a.equals(c)); //false
	
	
    }
}
