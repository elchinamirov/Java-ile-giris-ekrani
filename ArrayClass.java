import java.util.Arrays;

public class ArrayClass {
    public static void main(String [] args){
int [] array= {55,45,65,75,85};
        System.out.println(Arrays.toString(array));


Arrays.sort(array);

        System.out.println(Arrays.binarySearch(array,55));
    System.out.println(Arrays.toString(array));

    Arrays.fill(array,13);
    System.out.println(Arrays.toString(array));
    }

}
