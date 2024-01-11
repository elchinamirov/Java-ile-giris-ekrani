public class MainPrimitiveAndReferenceDifference {
    public static void main(String [] args) {

        Car bmw=new Car();

        bmw.speed=120;
        bmw.color="red";
        Car kia=bmw;
        kia.speed=130;
        kia.color="green";
        System.out.println(bmw.speed);



        int a=3;
        int b=a;
        a=10;
        System.out.println(b);
    }}



