package category.w3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by u_kino07 on 2018. 4. 7..
 */
public class Category implements Node<Category> {
    private long catNo;
    private String title;
    private List<Category> children;

    public Category(String title) {
        this.title = title;
        this.children = new ArrayList<>();
    }

    public long getCatNo() {
        return catNo;
    }

    public void setCatNo(long catNo) {
        this.catNo = catNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public List<Category> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<Category> children) {
        this.children = children;
    }

    @Override
    public void addChild(Category category) {
        this.children.add(category);
    }

    @Override
    public void removeChild(Category node) {
        this.children.remove(node);
    }

    @Override
    public void moveChild(Category node, Category parent) {
        parent.getChildren().add(node);
        this.children.remove(node);
    }

    public boolean equals(Category category) {
        return this.catNo == category.getCatNo();
    }
}
