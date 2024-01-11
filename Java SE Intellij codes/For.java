public class For {
public static void main(String [] args){
    int sum=0;
    for (int i = 1; i < 20; i++) {

        if (i % 3 == 0) {
            sum += i;
            System.out.println(i);
        }
    }        System.out.println("_______________");


    System.out.println("sum = "+sum);
        }}