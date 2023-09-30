public class VarArgsExample {
    public static void main(String[] args) {
int i=sum(1,4,6,34,87,95);
        System.out.println(i); }
    static int sum(int...i) {
        int result = 0;
        for (int a : i) {
            result+=a;
        }
        return result;}


        //   static int sum(int a,int b,int c){
        //       int result=0;
        //     result=a+b+c;
//return result;

    }



