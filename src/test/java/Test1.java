import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by sj on 17/4/3.
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<String>();
        lists.add("s");
        lists.add("d");
        lists.add("f");
        lists.add("g");
        lists.add("h");

        List<String> newList = lists.stream().peek(item -> {
            if(item.equals("f")) {
                lists.remove("f");
            }
        }).collect(Collectors.toList());
        System.out.println(newList.size());

    }
}
