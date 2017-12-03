public class SuperArrayDriver{
  public static void main(String [] args){
        SuperArray test = new SuperArray();
    test.add("Sierra Kilo Yankee Echo");
    test.add(" Mission Report:");
    test.add("Success");
    System.out.println(test);   // Sierra Kilo Yankee Echo Mission Report: Success
    System.out.println(test.get(2)); //Success
    System.out.println(test.size()); // 3
    System.out.println(test.set(2,"Failure")); //Success
    System.out.println(test); // Sierra Kilo Yankee Echo Mission Report: Failure
    test.add(1, "Sir,"); //
    System.out.println(test);// Sierra Kilo Yankee Echo Sir, Mission Report: Failure
    System.out.println(test.size()); //4
    System.out.println(test.remove(1)); // Success
    System.out.println(test); // Sierra Kilo Yankee Echo Mission Report: Failure
    test.clear();
    System.out.println(test); //[]
    System.out.println(test.isEmpty());   //true

  }
}
