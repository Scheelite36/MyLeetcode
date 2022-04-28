import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String pattern = "((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}";
        System.out.println(Pattern.matches(pattern, "192.168.2.202"));
        System.out.println(Pattern.matches(pattern, "192.168.2.109"));
        System.out.println(Pattern.matches(pattern, "192.168.2.1"));
    }
}
