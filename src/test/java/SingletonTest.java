import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by u_kino07 on 2018. 5. 26..
 */
// 단일 원소 컬렉션
public class SingletonTest {
    @Test
    public void exampleOfSingletonCollections() {
        Set<String> longWay = new HashSet<String>();
        longWay.add("a");

        Set<String> shortWay = Collections.singleton("a");
        assertEquals(shortWay, longWay);
    }
}
