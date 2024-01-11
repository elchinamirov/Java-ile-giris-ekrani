package constructors.overloading;

public class MainConstructorsOverloading {
    public static void main(String[] args) {

Book java=new Book();
Book html=new Book(10);
Book css=new Book("CSS");



System.out.println(html.price);

System.out.println(css.name);

    }
}
