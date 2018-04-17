package category.w5;

import category.w4.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by u_kino07 on 2018. 4. 16..
 */
public class CategoryBuilder {

    public void build() {
        List<Category> categories = getDummyCategories(100);
        Map<Long, List<Category>> group = categories.stream().collect(Collectors.groupingBy(Category::getParentId));

        categories.stream().forEach(category -> {
            category.setChildren(group.get(category.getId()));
        });
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
