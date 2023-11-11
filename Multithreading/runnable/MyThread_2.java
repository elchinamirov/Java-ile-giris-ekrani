public class MyThread_2 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <=40; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);

        }
    }
}
