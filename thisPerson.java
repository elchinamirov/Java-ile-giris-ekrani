public class thisPerson {
    int age;
    String name;
    String phone;

    void printInfo(){
        System.out.println("name :"+this.name);
        System.out.println("age :"+this.age);
        System.out.println("phone :"+this.phone);
    }
    void writeInfo(){
        System.out.println("name :"+this.name);
        System.out.println("age :"+this.age);
        System.out.println("phone :"+this.phone);
    }
    public thisPerson(){
this("6453");
    }
    public thisPerson(String phone){
       this("Hesen","0505055050");


    }
    public thisPerson(String name,String phone){
       this.age=age;
       this.name=name;
    }
    public thisPerson(int age,String name,String phone){
        this.age=age;
        this.name=name;
        this.phone=phone;
    }
}
