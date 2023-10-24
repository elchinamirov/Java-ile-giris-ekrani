public class Exception extends Throwable {

public void doIt(){

    int a = 9;
    int b = 0;
    int c=0;
    try {
         c = a/b;
    }catch (Exception e){
    System.out.println(e.getMessage());
    e.printStackTrace();
    }
    System.out.println(c);
    System.out.println("Salam");


}}