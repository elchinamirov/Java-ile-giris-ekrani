import java.time.LocalDate;

public class Main19car {


    public static class Car {
        String model;
        int price;
        LocalDate publish;

        public Car(String model, int price, LocalDate publish) {
            super();
            this.model = model;
            this.price = price;
            this.publish = publish;
        }

        @Override
        public String toString() {

            return price + "";
        }

    }

}
