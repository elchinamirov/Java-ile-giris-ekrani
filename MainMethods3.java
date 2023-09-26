public class MainMethods3 {
    public static void main(String[] args) {
        MainMethods3 h=new MainMethods3();
        MainMethods3 m= new MainMethods3();

        yeahIm();
        h.sayHello();
        System.out.println("main1");
        yeahIm();
        m.sayHello();
        yeahIm();
        h.sayHello();
        System.out.println("main2");
        yeahIm();
    }
    public void sayHello() {
        System.out.println("hello");

    }
    public static void yeahIm(){
        System.out.println("SALAM");
    }
}
