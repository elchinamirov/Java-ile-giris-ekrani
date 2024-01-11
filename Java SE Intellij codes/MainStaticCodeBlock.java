public class MainStaticCodeBlock {
    static{
        System.out.println("Static-1");
        hello();
    }
    static{
        System.out.println("Static-2");

    }
    public static void hello(){
        System.out.println("hello");
    }


    public static void main(String [] args){
        MainStaticCodeBlock m1=new MainStaticCodeBlock();
        MainStaticCodeBlock m2=new MainStaticCodeBlock();
        MainStaticCodeBlock m3=new MainStaticCodeBlock();
    }

}
