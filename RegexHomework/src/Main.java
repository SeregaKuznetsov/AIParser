import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        // TEST 1
        System.out.println(testIPOne("255.22.11.3")); //t
        System.out.println(testIPOne("0.0.0.0")); //t
        System.out.println(testIPOne(" 253.22.11.3")); //f
        System.out.println(testIPOne("256.22.11.55")); //f
        System.out.println(testIPOne("3.5.6.")); //f
        System.out.println(testIPOne("1.2.3.4.5")); //f
        System.out.println(testIPOne("0.23.211.34.")); //f
        System.out.println(testIPOne("66.123.211.2 ")); //f

        TestingModule(2);
        TestingModule(3);
        TestingModule(4);
        TestingModule(5);
    }

    private static void TestingModule(int numberOfTest) {
        byte count;
        String [] numbers = new String[10];
        System.out.println("\nTEST " + numberOfTest + ". RANDOM NUMBERS:");
        for (int i = 0; i < 10; i++) {
            numbers[i] = Integer.toString((int)(Math.random()*100000));
            System.out.print(numbers[i] + " ");
        }

        switch (numberOfTest) {
            case 2:
                count = 0;
                for (String number : numbers) {
                    if (testTwo(number)) {
                        count++;
                    }
                }
                System.out.println("\nOбщее количество сгенерированных чисел, в которых нет трех четных цифр подряд = " + (10 - count));
                break;
            case 3:
                count = 0;
                for (String number : numbers) {
                    if (testThree(number)) {
                        count++;
                    }
                }
                System.out.println("\nОбщее количество сгенерированных чисел, которые содержат более 3 и менее 6 четных цифр и ни одной нечетной = " + count);
                break;
            case 4:
                count = 0;
                for (String number : numbers) {
                    if (testFour(number)) {
                        count++;
                    }
                }
                System.out.println("\nОбщее количество сгенерированных чисел, в которых нет двух четных или двух нечетных чисел подряд = " + count);
                break;
            case 5:
                count = 0;
                for (String number : numbers) {
                    if (testFive(number)) {
                        count++;
                    }
                }
                System.out.println("\nОбщее количество сгенерированных чисел, в которых как минимум 2 раз встречается группа из 2х четных цифр = " + count);
                break;
        }
    }


    private static boolean testIPOne(String testString) {
        Pattern p = Pattern.compile("^(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[0-9]{2}|[0-9])(\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[0-9]{2}|[0-9])){3}$");
        Matcher m = p.matcher(testString);
        System.out.print(testString + " ");
        return m.matches();
    }

    private static boolean testTwo(String testString) {

        Pattern p = Pattern.compile("(\\d*([0,2,4,6,8]{3})\\d*)");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    private static boolean testThree(String testString) {

        Pattern p = Pattern.compile("^[0,2,4,6,8]{3,6}$");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    private static boolean testFour(String testString) {

        Pattern p = Pattern.compile("\\d|([0,2,4,6,8][1,3,5,7,9]([0,2,4,6,8])?)+|([1,3,5,7,9][0,2,4,6,8]([1,3,5,7,9])?)+");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    private static boolean testFive(String testString) {

        Pattern p = Pattern.compile("\\d*([0,2,4,6,8]{2})\\d*([0,2,4,6,8]{2})");
        Matcher m = p.matcher(testString);
        return m.matches();
    }
}