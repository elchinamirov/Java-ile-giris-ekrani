public class Multithreading {
    public static void main(String[] args ) throws InterruptedException {
        System.out.println("begin");
        for (int i = 1; i <=30; i++) {
            Thread.sleep(100);
            System.out.println(i);

        }

        System.out.println("end");

    }
}
