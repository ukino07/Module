package category.w4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by u_kino07 on 2018. 4. 7..
 */
public class CategoryTest {
    ObjectMapper mapper = new ObjectMapper();
    TreeBuilder<Category> treeBuilder = new CategoryTreeBuilder();

    @Before
    public void makeTree() throws Exception {
        treeBuilder.setNodes(getDummyCategories(100));
        treeBuilder.build();
//
//        System.out.println("[root] : ");
//        System.out.println(mapper.writeValueAsString(treeBuilder.getTree(0L)));
//        System.out.println(mapper.writeValueAsString(treeBuilder.getTree()));
    }

    @Test
    public void testTreeCategory() throws Exception {
//        assertEquals(0L, treeBuilder.getTree(0L).getId());
//        assertEquals(4, treeBuilder.getAllTree().getChildren().size());
//        assertEquals(true, treeBuilder.getTree(1L).getChildren().get(0).getId() == 4L);
    }

    @Test
    public void testFlatCategory() throws JsonProcessingException {

    }



    private List<Category> getDummyCategories(int count) {
        // 카테고리 준비 TODO. DB table
        List<Category> categories = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            categories.add(new Category(i, i / 4, "category " + i));
        }

        return categories;
    }
}
