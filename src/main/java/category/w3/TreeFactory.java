package category.w3;

/**
 * Created by u_kino07 on 2018. 4. 7..
 */
public class TreeFactory<T extends Node> {
    private T root;
    // TODO. 담고 있는 list 가 필요하고  build 할 때 촤자자작 만드는 애가 필요하다

    public TreeFactory(T root) {
        this.root = root;
    }

    public void addNode(T node, T parentNode) {
        parentNode.addChild(node);
    }

    public void deleteNode(T node, T parentNode) {
        parentNode.removeChild(node);
    }

    public void moveNode(T node, T oldParentNode, T newParentNode) {
        oldParentNode.moveChild(node, newParentNode);
    }

    public T getTree(T topNode) {
        return root;
    } // TODO. ?? 자식가져오는거

    public T getAllTree() {
        return getTree(root);
    }


//    public Node build() {} // TODO. 빌드하면 촤자작 나와야함
}
