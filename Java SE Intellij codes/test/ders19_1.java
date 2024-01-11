import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ders19_1 {


    public class Main19_01 {

        public static void main(String[] args) {
            ArrayList<Main19car.Car> cars = new ArrayList<Main19car.Car>();
            cars.add(new Main19car.Car("a", 3, LocalDate.of(1999, 2, 12)));
            cars.add(new Main19car.Car("b", 1, LocalDate.of(2010, 4, 12)));
            cars.add(new Main19car.Car("c", 2, LocalDate.of(2012, 11, 12)));
            // price
            // Collections.sort(cars);

            // model
            // Collections.sort(cars);
            // System.out.println(cars);

            Comparator<Main19car.Car> price = new Comparator<Main19car.Car>() {

                @Override
                public int compare(Main19car.Car o1, Main19car.Car o2) {

                    return o1.price - o2.price;
                }
            };

            Comparator<Main19car.Car> model = new Comparator<Main19car.Car>() {

                @Override
                public int compare(Main19car.Car o1, Main19car.Car o2) {

                    return o1.model.compareTo(o2.model);
                }
            };

            // priec
            Collections.sort(cars, price);
            System.out.println(cars);

            Collections.sort(cars, model);
            System.out.println(cars);
        }

    }
}
