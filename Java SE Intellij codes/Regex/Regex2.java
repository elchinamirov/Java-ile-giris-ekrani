public class Regex2 {
    public static void main(String[] args ){
        String phone1="0554443322";
        String phone2="0554443322";
        String phone3="055-444-33-22";
        String phone4="0554443322";

        // 000-000-00-00
String formatPhone="[0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]{2}";
        System.out.println(phone1.matches(formatPhone));

        System.out.println(phone2.matches(formatPhone));

        System.out.println(phone3.matches(formatPhone));

        System.out.println(phone4.matches(formatPhone));
System.out.println("-------------------------");

        String email1="elcinemirov533@gmail.com";
        String email2="elcinemirov533gmail.commmm";

        String formatEmail ="[0-9a-zA-Z]+@[a-z]+\\.[a-z]{2,4}";
        System.out.println(email1.matches(formatEmail));
        System.out.println(email2.matches(formatEmail));

    }
}
