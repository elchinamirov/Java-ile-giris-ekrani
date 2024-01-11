public class MainMultithreading {
    public static void main(String[] args ) throws InterruptedException {
        System.out.println("begin");
MyThread t1=new MyThread();
t1.start();
        System.out.println("end");

    }
}
