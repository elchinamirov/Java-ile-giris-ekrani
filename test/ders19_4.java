import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ders19_4 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(29);
        numbers.add(22);
        numbers.add(92);

        Collections.sort(numbers);

        System.out.println(numbers.get(numbers.size()-1));

    }

}

