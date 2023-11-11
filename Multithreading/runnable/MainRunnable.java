public class MainRunnable {
    public static void main(String [] args ){
        System.out.println("Begin");
        MyThread_2 thread1=new MyThread_2();
        Thread t1= new Thread(thread1);
        t1.start();
        System.out.println("End");

    }
}
