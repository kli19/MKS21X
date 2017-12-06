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
	code += numToBar("" + checksum(zip));
	return "|" +  code + "|";

    }

    public String toString(){
	return getCode() + " (" + getZip() + ")" ;
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
	    code += numToBar(zip.substring(i, i+1));
	}
	code += numToBar("" + checksum(zip));
	return "|" +  code  + "|";
    }

    public static String toZip(String code){
	if (code.length() != 32) {
	    throw new IllegalArgumentException();
	}

	if (code.charAt(0)!= '|' || code.charAt(31) != '|'){
	    throw new IllegalArgumentException();
	}
	    
	String zip = "";
	String num = "";
	for (int i = 1; i < code.length()-5; i= i+5){
	    num = barToNum(code.substring(i, i+5));
	    if (num.equals("-1")){
		throw new IllegalArgumentException();
	    }
	    zip += num;
	}

	if (checksum(zip.substring(0,5)) != Integer.parseInt(zip.substring(5))){
	    throw new IllegalArgumentException();
	}
	
	
	return zip.substring(0,5);
    }

    public static String numToBar(String num){
	return dictionary[Integer.parseInt(num)];
    }

    public static String barToNum(String bar){
	return "" + java.util.Arrays.asList(dictionary).indexOf(bar);

    }

    public static void main(String[]args){
	
    	Barcode a = new Barcode("10282");
    	Barcode b = new Barcode("10282");
    	Barcode c = new Barcode("10101");
    
    	//System.out.println("a: " + a); //a: |:::||||:::::|:||::|:::|:|::||:| (10282)
    	//System.out.println("b: " + b); //b: |:::||||:::::|:||::|:::|:|::||:| (10282)
    	//System.out.println("c: " + c); //c: |:::||||::::::||||::::::||::||:| (10101)

	//System.out.println(a.compareTo(b)); //0
	//System.out.println(c.compareTo(a)); //negative
	//System.out.println(a.compareTo(c)); //positive
	
	
	//System.out.println(a.equals(b)); //true
    	//System.out.println(a.equals(c)); //false


	//System.out.println(toCode("10282")); // returns |:::||||:::::|:||::|:::|:|::||:|
	//System.out.println(toZip("|:::||||:::::|:||::|:::|:|::||:|")); //returns 10282	
	       
	//should throw IllegalArgumentException

	//System.out.println(toCode("1234")); //length less than 5
	//System.out.println(toCode("123456")); // length greater than 5
	//System.out.println(toCode("1234z")); //contains non digit
	
	//Barcode x = new Barcode("123"); //length less than 5
	//Barcode x = new Barcode("123456"); //length greater than 5
	//Barcode x = new Barcode("123ab"); //contains non digit
	
	//System.out.println(toZip("|||:::||:::||:::||:::||:::||:::")); //length less than 32
	//System.out.println(toZip("|||:::||:::||:::||:::||:::||:::||||"));//;ength greater than 32
	//System.out.println(toZip("|||:::||:::||:::||:::||:::||:::z")); //not enclosed in bars (|)
	//System.out.println(toZip("a||:::||:::||:::||:::||:::||:::|")); //not enclosed in bars (|)
	//System.out.println(toZip("|123456789123456789123456789123|")); //non-barcode characters are used
	//System.out.println(toZip("|:::||||:::1::||||::::::||::||:|")); //non-barcode characters are used
	//System.out.println(toZip("|||:::||:::||:::||:::||::::::|||")); //invalid checksum

	
	
    }
}
