public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <=30; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);

        }
    }
}
