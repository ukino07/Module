package category.e1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Created by u_kino07 on 2018. 4. 14..
 */
public class TreeBuilder {
    private List<Category> categories = new ArrayList<>();

    public void setCategory(List<Category> category) {
        categories = category;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public Category build() {
        Category root = new Category();
        root.setId(0);
        return toTree(root);
    }

    private Category toTree(Category category) {
        List<Category> children = new ArrayList<>();
        categories.stream()
                .filter(cat -> cat.getParentId() == category.getId())
                .forEach(cat -> children.add(toTree(cat)));
        category.setChildren(children);
        return category;
    }


    /* test */
    public static void main(String[] args) {
        TreeBuilder builder = new TreeBuilder();
        builder.setCategory(getCategories(100));
        System.out.println(builder.build());
    }

    public static List<Category> getCategories(long size) {
        return LongStream.range(1, size)
                .boxed()
                .map(id -> getCategory(id, id / 4, "category " + id))
                .collect(Collectors.toList());
    }

    public static Category getCategory(long id, long parentId, String name) {
        Category category = new Category();
        category.setId(id);
        category.setParentId(parentId);
        category.setName(name);
        return category;
    }


}
