import jdk.nashorn.internal.runtime.options.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by sj on 17/4/3.
 */
public abstract class TestOptional {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        System.out.println(1 << 30);
//        System.out.println(1000 >>> 16);
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(3);
        l2.add(4);
        l1.removeAll(l2);
        l1.stream().forEach(item -> {
            System.out.print(item + " ");
        });
    }
}
