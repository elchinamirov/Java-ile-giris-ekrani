import java.util.HashSet;
import java.util.Set;

public class ders19_5 {
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        s1.add(32);
        s1.add(43);
        s1.add(54);

        Set<Integer> s2 = new HashSet<>();
        s1.add(54);
        s1.add(76);
        s1.add(43);

        s1.containsAll(s2);
    }
    }
