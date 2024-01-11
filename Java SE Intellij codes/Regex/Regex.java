public class Regex {
    public static void main(String[] args ){
        String phone1="0554443322";
        String phone2="0554443322";
        String phone3="055-444-33-22";
        String phone4="0554443322";

        // 000-000-00-00
String format="[0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]{2}";
        System.out.println(phone1.matches(format));

        System.out.println(phone2.matches(format));

        System.out.println(phone3.matches(format));

        System.out.println(phone4.matches(format));


    }
}
