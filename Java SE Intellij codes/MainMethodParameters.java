public class MainMethodParameters {
public static void main(String[]args){
    MainMethodParameters m=new MainMethodParameters();
    m.sayHi(10,"ali");
    tellMe(10,"Elchin");
}
public void sayHi(int a,String name){
    System.out.println(name+", a = "+a);
}
public static void tellMe(int i, String message){
    System.out.println(message+", i="+i);

}
}
