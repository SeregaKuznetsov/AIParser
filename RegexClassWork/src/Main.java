import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        System.out.println(testURL("89047640086")); //t
        System.out.println(testURL("89456667657")); //t
        System.out.println(testURL("8(904)7640086")); //t
        System.out.println(testURL("8(756)2334444")); //t
        System.out.println(testURL("78900000000")); //t
        System.out.println(testURL("+78900000000")); //t
        System.out.println(testURL("+88900000000")); //f
        System.out.println(testURL("8(9000060000")); //f
    }


    private static boolean testURL(String testString) {
        Pattern p = Pattern.compile("(\\+?7|8)(\\(\\d{3}\\)|\\d{3})\\d{7}");
        Matcher m = p.matcher(testString);
        System.out.print(testString + " ");
        return m.matches();
    }
}