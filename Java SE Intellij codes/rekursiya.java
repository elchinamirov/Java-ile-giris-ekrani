public class rekursiya {
    public static void main(String[] args){
rekursiya mr=new rekursiya();
mr.m(8);
    }
    void m(int i){
        if (i==5){
            System.out.println(i);

        }else{
            m(5);
            System.out.println("else");
        }
    }
}
