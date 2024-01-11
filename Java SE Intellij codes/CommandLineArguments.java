public class CommandLineArguments {
    public static void main(String[] args){
int[] a={12,8,33,9};
        printArray(a);
    }
    static void printArray(int[] array){
        for (int i : array) {
            System.out.println(i);

        }
    }
}
