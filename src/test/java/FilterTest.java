import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by u_kino07 on 2018. 5. 14..
 */
public class FilterTest {
    static int count = 0;
    @Test
    public void 테스트() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        List<Integer> result = list.stream()
                .filter(each -> {
                    return each < 6;
                }).filter(each -> {
                    return each > 2;
                })
                .collect(Collectors.toList());


//        Stream<List<Integer>> result = Stream.of(list)
//        .filter(each -> {
//            System.out.println("첫번째");
//            return true;
//        }).filter(each -> {
//                    System.out.println("두번째");
//            return true;
//        });
    }
}
