public class MainOverLoading {
    public static void main(String [] args){
        MainOverLoading m=new MainOverLoading();
        m.sum();
        m.sum(3,4);
        m.sum("Elchin",19);
        m.sum(15,4,9);
    }
    public void sum(){
        System.out.println("SUM");

    }
    public void sum(int a,int b){
        System.out.println(a+b);
    }
    public void sum(String name,int age){
        System.out.println(name +" "+ age);
    }
    public void sum(int d,int f, int p){
        System.out.println(d*(f+p));
    }
}

//SUM
//7
//Elchin 19
//195