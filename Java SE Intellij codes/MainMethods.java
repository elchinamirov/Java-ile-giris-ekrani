public class MainMethods {

    public static void main(String[] args) {
        System.out.println("main1");
        MainMethods h=new MainMethods();
        MainMethods m= new MainMethods();
        m.sayHello();
        System.out.println("main2");
        h.yeahIm();
    }
    public void sayHello() {
        System.out.println("hello");

    }

    public void yeahIm() {
        System.out.println("hola");
    }

}
