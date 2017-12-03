public class Barcode implements Comparable<Barcode>{
    private String zip;

    public Barcode(String zip){
	this.zip = zip;
    }

    public String getZip(){
	return zip;
    }

    public String getCode(){
	return "";
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
	return 0;
    }
}
