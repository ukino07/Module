package category.w4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class TreeBuilder<T extends Node> {
    ObjectMapper mapper = new ObjectMapper();

    protected HashMap<Object, List<T>> map = new HashMap<>();
    protected List<T> nodes = new ArrayList<>();
    protected T root;

    public void setNodes(List<T> nodes) {
        this.nodes = nodes;
    }

    public TreeBuilder<T> build() throws JsonProcessingException {

        for (T node : this.nodes) {
            if (map.containsKey(node.getParentKey())) {
                map.get(node.getParentKey()).add(node);
            } else {
                List<T> newList = new ArrayList<T>();
                newList.add(node);
                map.put(node.getParentKey(), newList);
            }
        }

//        setTree();

        System.out.println("[부 map] : ");
        System.out.println(mapper.writeValueAsString(map));
        System.out.println("[부 root] : ");
        System.out.println(mapper.writeValueAsString(root));

        return this;
    }

    protected abstract void setTree();
}
