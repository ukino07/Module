package w2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CategoryTest {
    ObjectMapper mapper = new ObjectMapper();
    Category tree;
    List<Category> flat = new ArrayList<Category>();

    @Before
    public void prepareCategoryList() throws Exception {
        // 카테고리 준비
        List<Category> categories = new ArrayList<Category>();
        categories.add(new Category()); // 0 (최상위)
        categories.add(new Category()); // 1
        categories.add(new Category()); // 2
        categories.add(new Category()); // 3
        categories.add(new Category()); // 4

        categories.add(new Category(1L)); // 5
        categories.add(new Category(1L)); // 6
        categories.add(new Category(1L)); // 7
        categories.add(new Category(1L)); // 8

        categories.add(new Category(2L)); // 9
        categories.add(new Category(2L)); // 10
        categories.add(new Category(2L)); // 11

        categories.add(new Category(3L)); // 12
        categories.add(new Category(3L)); // 13

        categories.add(new Category(4L)); // 14

        categories.add(new Category(5L)); // 15
        categories.add(new Category(5L)); // 16
        categories.add(new Category(5L)); // 17

        categories.add(new Category(6L)); // 18
        categories.add(new Category(6L)); // 19

        categories.add(new Category(7L)); // 20

        categories.add(new Category(9L)); // 21
        categories.add(new Category(9L)); // 22

        categories.add(new Category(10L)); // 23

        categories.add(new Category(12L)); // 24

        categories.add(new Category(15L)); // 25
        categories.add(new Category(15L)); // 26
        categories.add(new Category(15L)); // 27

        categories.add(new Category(16L)); // 28
        categories.add(new Category(16L)); // 29

        categories.add(new Category(17L)); // 30

        categories.add(new Category(18L)); // 31
        categories.add(new Category(18L)); // 32

        categories.add(new Category(19L)); // 33

        categories.add(new Category(21L)); // 34
        categories.add(new Category(21L)); // 35

        categories.add(new Category(25L)); // 36
        categories.add(new Category(25L)); // 37
        categories.add(new Category(25L)); // 38

        categories.add(new Category(36L)); // 39

        CategoryManager.registerCategories(categories);

        System.out.println("[catmap] : ");
        System.out.println(mapper.writeValueAsString(CategoryManager.getCatMap()));
        System.out.println("[chainmap] : ");
        System.out.println(mapper.writeValueAsString(CategoryManager.getChainMap()));
    }

    @Test
    public void testTreeCategory() throws Exception {
        tree = CategoryManager.getCategoryTree(0L);

        assertEquals(36L, CategoryManager.getCatMap().get(39L).getParentNo());
        assertEquals(15L, CategoryManager.getCatMap().get(25L).getParentNo());
    }

    @Test
    public void testFlatCategory() throws JsonProcessingException {
        flat = CategoryManager.getCategoryFlat(0L);

        assertEquals(4, flat.size());
    }

    @After
    public void print() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        if (tree != null) {
            System.out.println("[tree] : ");
            System.out.println(mapper.writeValueAsString(tree));
        }

        if (! CollectionUtils.isEmpty(flat)) {
            System.out.println("[flat] : ");
            System.out.println(mapper.writeValueAsString(flat));
        }
    }
}
