public class StringBuilder {
    public static void main(String [] args) throws InterruptedException {
        java.lang.StringBuilder stringBuilder=new java.lang.StringBuilder();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append("HELLO");
            Thread.sleep((long) 100.00);
        }
        System.out.println("done");
        }}
