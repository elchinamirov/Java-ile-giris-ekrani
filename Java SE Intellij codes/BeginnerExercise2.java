import java.util.Scanner;
public class BeginnerExercise2 {
    public static void main(String [] args){

        Scanner scanner=new Scanner(System.in);
        System.out.println("Yasinizi yazin");
         String age= scanner.nextLine();
         int X= Integer.parseInt(age)*12;
       String s1= String.format("Aylarla yasiniz: %d",X);
       System.out.println(s1);
        scanner.close();}
}
