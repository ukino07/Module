import org.junit.Test;

import java.util.*;

/**
 * Created by u_kino07 on 2018. 5. 26..
 */
public class UnmodifiableCollectionTest {
    @Test(expected = UnsupportedOperationException.class)
    public void unmodifiableCollectionsThrowException() {
        List<String> list = new ArrayList<String>();
        list.add("a");

        Collection<String> unmodifiable = Collections.unmodifiableCollection(list);
        Iterator<String> all = unmodifiable.iterator();
        all.next();
        all.remove();
    }
}
