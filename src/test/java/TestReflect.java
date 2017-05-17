/**
 * Created by sj on 17/4/13.
 */
public class TestReflect {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int length = 16;
        int h = 16;
        System.out.println(h &(length - 1));
        System.out.println(h % length);
    }
}
