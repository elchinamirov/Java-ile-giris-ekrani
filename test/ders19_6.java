import java.util.HashMap;
import java.util.Map;

public class ders19_6 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Elcin", 21);
        map.put("Yalcin", 21);
        map.put("Elcin", 221);// add


        System.out.println(map);

        System.out.println(map.containsKey("Elcin"));
        System.out.println(map.containsValue(45));
        map.replace("Elcin", 21);

        Integer i=map.get("Yalcin");
        System.out.println(i);



    }
}
