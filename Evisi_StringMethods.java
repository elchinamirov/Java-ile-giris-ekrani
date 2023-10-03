import java.util.Arrays;

public class Evisi_StringMethods {
    public static void main(String [] args){
        String name=new String("Meherrem");
        System.out.println(name);
        String message=new String("Java dilini oyrenmek maraqli ve faydalidir");
        System.out.println(message);
        System.out.println(message.length());
        char c=message.charAt(2);
        System.out.println(c);
        System.out.println(message.indexOf("i"));
        System.out.println(message.toLowerCase()+" / "+ message);
        System.out.println(message.toUpperCase()+" / "+ message);
System.out.println(message.contains("z"));
boolean b1=message.endsWith("e");
System.out.println(b1);
boolean b2=message.startsWith("J");
System.out.println(b2);
name=" Ayxan ";
System.out.println(name);
System.out.println(name.trim());



name="Kamil"; //????????

        char a=name.charAt(0);
        char b=name.charAt(1);
        char d=name.charAt(2);
        char e=name.charAt(3);

        System.out.println(a);
        System.out.println(b);
        System.out.println(d);
        System.out.println(e);



name="Huseyn Mehdizade"; //??????
String [] nameArray=name.split("");
System.out.println(Arrays.toString(nameArray));
String[] nameArray2=name.split("a",3);
System.out.println(Arrays.toString(nameArray2));



    }
}
