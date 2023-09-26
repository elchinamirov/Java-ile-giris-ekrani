public class MainUsingReturn {
    public static void main(String[] args){
        MyMethods m= new MyMethods();
    m.printOddNumber(2);
        m.printOddNumber(7);
    }
    public void printOddNumber(int number) {
        System.out.println("printOddNumber started");
        if (number % 2 == 1) {
            if (number % 2 == 0) {
                return;
            }

            System.out.println(number);
            System.out.println("printOddNumber ended");
        }
    }
}
