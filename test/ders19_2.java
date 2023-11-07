import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ders19_2 {
    public static void main(String[] args) {
        var cars = new ArrayList<Main19car.Car>();
        cars.add(new Main19car.Car("a", 3, LocalDate.of(1999, 2, 12)));
        cars.add(new Main19car.Car("b", 1, LocalDate.of(2010, 4, 12)));
        cars.add(new Main19car.Car("c", 2, LocalDate.of(2012, 11, 12)));

        System.out.println(cars);
        Iterator<Main19car.Car> i = cars.listIterator();

        while (i.hasNext()) {
            Main19car.Car c = i.next();

            if (c.price >= 2) {
                i.remove();
            }
        }
        System.out.println(cars);

    }}
