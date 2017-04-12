/**
 * Created by sj on 17/4/3.
 */
public class TestString2 {
    public static void main(String[] args) {
        String q = "test";
        System.out.println(q);
        String qq = toUpperCase(q);
        System.out.println(qq);
        System.out.println(q);

    }

    public static String toUpperCase(String s) {
        return s.toUpperCase();
    }
}
