package category.w4;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by u_kino07 on 2018. 4. 7..
 */
public class Category implements Node<Category> {
    private long id;
    private long parentId;
    private String title;
    private List<Category> children;

    public Category(long id, long parentId, String title) {
        this.id = id;
        this.parentId = parentId;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setChildren(List<Category> children) {
        this.children = children;
    }

    @Override
    public void addChild(Category child) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }

        this.children.add(child);
    }

    @Override
    public void removeChild(Category child) {
        if (this.children == null || ! this.children.contains(child)) {
            return;
        }

        this.children.remove(child);
    }

    @Override
    public List<Category> getChildren() {
        return this.children;
    }

    @Override
    @JsonIgnore
    public Long getParentKey() {
        return getParentId();
    }

    @Override
    @JsonIgnore
    public Long getKey() {
        return getId();
    }

    @Override
    public boolean equals(Object category) {
        if (category instanceof Category) {
            return (this.getId() == ((Category)category).getId());
        }

        return false;
    }

    @Override
    public String toString() {
        return "{ \"id\" : " + id +
                ", \"parentId\" : " + parentId +
                ", \"title\" : \"" + title + "\"" +
                ", \"children\" : " + children +
                "}";

    }
}
