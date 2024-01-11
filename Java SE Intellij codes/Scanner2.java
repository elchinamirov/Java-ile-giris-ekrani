import java.util.Scanner;

public class Scanner2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Salam,Adinizi yazin : ");
        String name = scanner.nextLine();
        System.out.println("Soyadinizi yazin : ");
        String surname=scanner.nextLine();
        System.out.println("Yasinizi qeyd edin : ");
        int age=scanner.nextInt();
        System.out.println("Teshekkurler,qeyde alindi");
        scanner.close();
    }}
