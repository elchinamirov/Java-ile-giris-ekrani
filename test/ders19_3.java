import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ders19_3 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Elcin");
        names.add("Yalcin");
        names.add("Gulcin");

        Collections.sort(names);
        Collections.reverse(names);
        System.out.println(names);

    }

}

