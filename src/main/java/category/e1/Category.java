package category.e1;

import java.util.List;

/**
 * Created by u_kino07 on 2018. 4. 14..
 */
public class Category {
    private long id;
    private long parentId;
    private String name;
    private List<Category> children;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public String toString() {
        return "{" +
                "id:" + id + "," +
                "parentId:" + parentId + "," +
                "name:\"" + name + "\"," +
                "children:" + children +
                "}";
    }
}
