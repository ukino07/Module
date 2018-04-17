package category.w4;

import java.util.List;

/**
 * Created by u_kino07 on 2018. 4. 7..
 */
public interface Node<T> {
    void setChildren(List<T> nodes);

    void addChild(T node);

    void removeChild(T node);

    List<T> getChildren();

    Object getParentKey();

    Object getKey();

    boolean equals(Object obj);
}
