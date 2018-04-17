package category.w5;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by u_kino07 on 2018. 4. 7..
 */
public class CategoryTest {
    ObjectMapper mapper = new ObjectMapper();
    CategoryBuilder builder = new CategoryBuilder();

    @Before
    public void makeTree() throws Exception {
        builder.build();
    }

    @Test
    public void testTreeCategory() throws Exception {
    }
}
