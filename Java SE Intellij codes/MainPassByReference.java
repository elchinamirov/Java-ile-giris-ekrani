public class MainPassByReference {
    public static void main(String[] args) {


        Employee isci = new Employee();
        isci.age = 20;
        isci.name = "Elchin";
        MyMethods3 m = new MyMethods3();
        System.out.println("evvel : " + isci.salary);
        m.calculateSalary(isci);
        System.out.println("sonra : " + isci.salary);
    }

    //public class MyMethods3 {
    //public void calculateSalary(Employee isci){
    //int salary=isci.age*10;
    //isci.salary=salary;
    //}
    //}

}
        //public class Employee {
       //    int age;
      //    String name;
     //    int salary;
    //}