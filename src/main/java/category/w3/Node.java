package category.w3;

import java.util.List;

/**
 * Created by u_kino07 on 2018. 4. 7..
 */
public interface Node<T> { // TODO. 기능 좀 확인해야함 필요한지
    void setChildren(List<T> nodes);

    void addChild(T node); //

    void removeChild(T node); //

    void moveChild(T node, T parentNode);

    List<T> getChildren();
}
