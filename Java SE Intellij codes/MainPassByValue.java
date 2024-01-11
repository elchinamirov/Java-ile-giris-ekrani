public class MainPassByValue {
    public static void main(String[] args){
MyMethods2 m=new MyMethods2();

int age=20;    //pass by value
System.out.println("evvel =" + age);

        m.changeAge(age);
        System.out.println("sonra =" + age);
    }

      // public class MyMethods2 {
     //public void changeAge(int age){
    //    age=40;

}
