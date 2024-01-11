import java.util.*;

public class ders19_7 {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Adil");
        names.add("Asef");
        names.add("Hesen");
        names.add("Adil");
        names.add("Orxan");
        names.add("Adil");
        names.add("Adil");
        names.add("Orxan");
        names.add("Adil");
        names.add("Hesen");

        Map<String, Integer> map = new HashMap<>();

        for (String name : names) {
            if (map.containsKey(name)) {
                map.replace(name, map.get(name) + 1);

            } else {
                map.put(name, 1); // Adil 1
            }
        }
        System.out.println(map);
        map.remove("Adil");
        System.out.println(map);
        Set<String> keySet = map.keySet();
        System.out.println(keySet);
        Collection<Integer> values = map.values();
        System.out.println(values);

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();




    }
}
