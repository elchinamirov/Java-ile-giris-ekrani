public class MainReturnValue {
    public static void main(String[] args){

        MainReturnValue m=new MainReturnValue();
        int c=m.sum(2,3);
        System.out.println(c);
    }
    public int sum(int a, int b){
        int c=a+b;
//System.out.println("c="+c);
        return c;}}


