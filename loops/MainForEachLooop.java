package loops;

public class MainForEachLooop {
    public static void main(String [] args){
        int [] array={23,6,88,14,9};
        for (int i :array) {
            System.out.println(i);

        }
        for (int i = 0; i<array.length; i++) {
            System.out.println(array[i]);

        }

    }
}
