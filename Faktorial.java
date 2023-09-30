public class Faktorial {
public static void main(String [] args){
int result=f(4);
System.out.println(result);
}
static int f(int i) {
    if (i == 1) {
        return 1;
    } else {
        return i*f(i-1);
    }

    }


}